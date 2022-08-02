package 数组与矩阵;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @description: 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 你必须找到一个内存复杂度优于O(n2) 的解决方案。
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * @return:
 * @Author: M
 * @create: 2022/7/30 20:23
 */

public class Test5 {
    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());   //  优先队列
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (MaxPQ.size() == k && matrix[i][j] > MaxPQ.peek()) break;
//                MaxPQ.offer(matrix[i][j]);
//                if (MaxPQ.size() > k) MaxPQ.poll();
//            }
//        }
//        return MaxPQ.peek();
        int m = matrix.length, n = matrix[0].length;    //获取矩阵信息
        int low = matrix[0][0], high = matrix[m - 1][n - 1];   //获取矩阵最大值最小值
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) count++;  //统计比mid小的个数
                }
            }
            if (count < k) low = mid + 1;  //如果计数比k小，说明mid需要往后调
            else high = mid - 1;  //  反之亦然
        }
        return low;
    }

    @Test
    public void test() {
//        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix = {{1, 2}, {1, 3}};
        System.out.println(kthSmallest(matrix, 3));
    }
}
