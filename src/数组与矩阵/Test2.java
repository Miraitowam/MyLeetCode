package 数组与矩阵;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * @return:
 * @Author: M
 * @create: 2022/7/30 12:34
 */

public class Test2 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int[][] res = new int[r][c];
        int m = 0, n = 0, index = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                index = i * mat[0].length + j;
                m = index / c;
                n = index % c;
                res[m][n] = mat[i][j];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] res = matrixReshape(mat, 2, 2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
