package 动态规划;

import org.junit.Test;

/**
 * @description: 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:32
 */

public class Test23 {
    public int combinationSum4(int[] nums, int target) {
        //dp_i表示使用凑成i的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //先背包后物品
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i < num) continue;
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 5};
        int target = 5;
        System.out.println(combinationSum4(nums, target));
    }
}
