import java.util.Arrays;

/**
 * @description: 排序按矩阵查找
 * @return:
 * @Author: M
 * @create: 2022/7/14 12:25
 */

public class Test {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //获得矩阵的长宽
        int row = 0;
        int col = matrix[0].length - 1;
        //如果比最小的都小，最大的都大直接返回找不到
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][col] || matrix == null) return false;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public int candy (int[] arr){

    }

    @org.junit.Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 26));
    }
}
