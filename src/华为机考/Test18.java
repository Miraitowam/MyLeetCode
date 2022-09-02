package 华为机考;

import org.junit.Test;

public class Test18 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length + 1];
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left != right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
