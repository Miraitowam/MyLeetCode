package 数组与矩阵;
/**
 * @description: 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/30 19:59
 */

import org.junit.Test;

public class Test4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length - 1, n = 0;    //从右上角开始搜索
        while (m >= 0 && n < matrix.length) {
            if (matrix[n][m] > target) {     //如果比target大那就找当前数左边
                m--;
            } else if (matrix[n][m] < target) {     //如果比target小那就找当前数右边
                n++;
            } else {
                return true;        //说明找到了
            }
        }
        return false;
    }

    @Test
    public void test() {
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = {{-5}};
        int target = -5;
        System.out.println(searchMatrix(matrix, target));
    }
}
