package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * @return:
 * @Author: M
 * @create: 2022/9/6 21:23
 */

public class Test26 {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = nums[i - 1] + sum[i - 1];
        int ans = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-1, -1, 1};
        System.out.println(subarraySum(nums, 0));
    }
}
