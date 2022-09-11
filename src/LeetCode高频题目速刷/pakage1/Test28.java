package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加inc。
 * 请你返回k次操作后的数组。
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * @return:
 * @Author: M
 * @create: 2022/9/7 13:56
 */

public class Test28 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int k = update[2];
            updateArray(res, start, end, k);
        }
        return res;
    }

    public void updateArray(int[] res, int start, int end, int k) {
        for (int i = start; i <= end; i++) res[i] += k;
    }

    @Test
    public void test() {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        getModifiedArray(5, updates);
    }

}
