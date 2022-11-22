package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 42. 连续子数组的最大和
 * @return:
 * @Author: M
 * @create: 2022/11/21 16:06
 */

public class Test6 {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {1, 2};
        System.out.println(maxSubArray(nums));
    }
}
