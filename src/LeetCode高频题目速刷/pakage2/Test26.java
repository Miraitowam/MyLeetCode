package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

public class Test26 {
    public void setZeroes(int[][] matrix) {
        boolean[][] isAdded = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0 || (matrix[i][j] == 0 && isAdded[i][j])) continue;
                int row = i, col = j;
                while (--row >= 0) {
                    if (matrix[row][j] == 0 && row != i) break;
                    matrix[row][j] = 0;
                    isAdded[row][j] = true;
                }
                row = i;
                while (++row <= matrix.length - 1) {
                    if (matrix[row][j] == 0 && row != i) break;
                    matrix[row][j] = 0;
                    isAdded[row][j] = true;
                }
                while (--col >= 0) {
                    if (matrix[i][col] == 0 && col != j) break;
                    matrix[i][col] = 0;
                    isAdded[i][col] = true;
                }
                col = j;
                while (++col <= matrix[i].length - 1) {
                    if (matrix[i][col] == 0 && col != j) break;
                    matrix[i][col] = 0;
                    isAdded[i][col] = true;
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
