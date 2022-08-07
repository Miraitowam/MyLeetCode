package 动态规划;

import org.junit.Test;

/**
 * @description: 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * @return:
 * @Author: M
 * @create: 2022/8/6 15:09
 */

public class Test18 {
    public int findTargetSumWays(int[] nums, int target) {
        //0-1背包问题，放入正或者放入负
        //先求和
        int sum = 0;
        for (int num : nums) sum += num;
        //这两种情况都说明无解无需计算
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        //问题转换为使得和为(sum + target) / 2一共有多少种方法
        //dp[i][j] 代表考虑前 i 个数，当前计算结果为 j 的方案数
        //初始化
        int[][] dp = new int[nums.length + 1][(sum + target) / 2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < (sum + target) / 2 + 1; j++) {
                dp[i][j] += dp[i - 1][j];
                if (nums[i - 1] <= j) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][(sum + target) / 2];
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1};
        int[] nums1 = {1};
        System.out.println(findTargetSumWays(nums, 1));
    }
}
