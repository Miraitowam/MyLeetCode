package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

/**
 * @description: 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个32-位 整数。
 * 子数组 是数组的连续子序列。
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * @return:
 * @Author: M
 * @create: 2022/9/19 21:33
 */

public class Test27 {
    public int maxProduct(int[] nums) {
        int temp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((temp > 0 && nums[i] > 0) || (temp < 0 && nums[i] < 0)) temp *= nums[i];
            else temp = nums[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-2,3,-4};
        System.out.println(maxProduct(nums));
    }
}
