package 华为机考;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @return: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Author: M
 * @create: 2022/8/29 17:25
 */

public class Test22 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 1) {
            for (int[] num : matrix) for (int t : num) res.add(t);
            return res;
        }
        int n = Math.min(matrix.length, matrix[0].length);
        int loop = 0;
        int start = 0;
        int i, j;
        while (loop++ < n / 2) {
            for (j = start; j < matrix[0].length - loop; j++) res.add(matrix[start][j]);
            for (i = start; i < matrix.length - loop; i++) res.add(matrix[i][j]);
            for (; j >= loop; j--) res.add(matrix[i][j]);
            for (; i >= loop; i--) res.add(matrix[i][j]);
            start++;
        }
        if (n % 2 == 1) res.add(matrix[start][start]);
        if (n % 2 == 1 && matrix.length > matrix[0].length)
            for (int k = start + 1; k < matrix.length - loop + 1; k++) res.add(matrix[k][start]);
        if (n % 2 == 1 && matrix.length < matrix[0].length)
            for (int k = start + 1; k < matrix[0].length - loop + 1; k++) res.add(matrix[start][k]);
        return res;
    }

    public int[][] generateMatrix(int n) {
        int loop = 0;
        int[][] res = new int[n][n];
        int start = 0;
        int count = 1;
        int i, j;
        while (loop++ < n / 2) {
            //模拟上侧从左到右
            for (j = start; j < n - loop; j++) res[start][j] = count++;
            //模拟右侧上到下
            for (i = start; i < n - loop; i++) res[i][j] = count++;
            //模拟下到右
            for (; j >= loop; j--) res[i][j] = count++;
            //模拟左侧从下到上
            for (; i >= loop; i--) res[i][j] = count++;
            start++;
            //特殊情况
            if (n % 2 == 1) res[start][start] = count;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] target = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
        System.out.println(spiralOrder(target));
    }
}
