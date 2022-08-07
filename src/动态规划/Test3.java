package 动态规划;

import org.junit.Test;

public class Test3 {
    //分开走，抢了第一家就绝对不碰最后一家反之亦然
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        //抢劫第一家
        int route1 = getRob(nums, 0, nums.length - 1);
        //抢劫第二家
        int route2 = getRob(nums, 1, nums.length);
        return Math.max(route1, route2);
    }

    public int getRob(int[] nums, int start, int end) {
        //dp[i]表示抢劫i能够取到的最高金额
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[start];
        dp[1] = nums[start + 1];
        dp[2] = dp[0] + nums[start + 2];
        for (int i = 3; i < end - start; i++) {
            //在这一点能取到的最大值=这天打劫+上次打劫最大值（上一次打劫i或者不打劫i的最大值）
            dp[i] = nums[i + start] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[nums.length - 2], dp[nums.length - 3]);
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
