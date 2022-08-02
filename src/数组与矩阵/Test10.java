package 数组与矩阵;

import org.junit.Test;

/**
 * @description: 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * @return:
 * @Author: M
 * @create: 2022/8/1 20:05
 */

public class Test10 {
    //只需要判断当前元素和右下角元素是否相等就行
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!isValid(matrix, i, j)) return false;
            }
        }
        return true;
    }

    public boolean isValid(int[][] matrix, int posX, int posY) {
        if (posY == matrix[0].length - 1 || posX == matrix.length - 1) return true;
        return matrix[posX][posY] == matrix[posX + 1][posY + 1];
    }

    @Test
    public void test() {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix = {{1, 2}, {2, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
