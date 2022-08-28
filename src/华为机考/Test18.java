package 华为机考;

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
}
