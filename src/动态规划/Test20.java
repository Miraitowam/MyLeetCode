package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 * 来源：力扣（LeetCode）
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * @return:
 * @Author: M
 * @create: 2022/8/6 22:04
 */

public class Test20 {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length, max = Integer.MAX_VALUE;
        //dp[i][j]:从前i种硬币中组成金额j所需最少的硬币数量。
        int[][] dp = new int[len + 1][amount + 1];
        // 初始化（没有任何硬币的情况）：只有 dp[0][0] = 0；其余情况均为无效值。
        // 这是由「状态定义」决定的，当不考虑任何硬币的时候，只能凑出总和为 0 的方案，所使用的硬币数量为 0
        //dp[i][0] = 0表示从前i个硬币中凑出金额0所需要的硬币数目为0
        for (int i = 1; i <= amount; i++) dp[0][i] = max;
        for (int i = 1; i <= len; i++) {    //遍历硬币
            for (int j = 1; j <= amount; j++) {    //遍历背包
                //要是重复取不到
                dp[i][j] = dp[i - 1][j];
                //硬币可以重复取的
                for (int k = 1; k * coins[i - 1] <= j; k++) {
                    //必须要判断dp[i-1][j-k*coins[i-1]]是不是最大值，如果不判断则会导致+k之后越界->非常关键
                    if (dp[i - 1][j - k * coins[i - 1]] == max) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == max ? -1 : dp[dp.length - 1][dp[0].length - 1];
    }

    //简化版
    public int coinChange2(int[] coins, int amount) {
        //题目求的值为 f(11)，第一次选择硬币时我们有三种选择。
        //假设我们取面额为 1 的硬币，那么接下来需要凑齐的总金额变为 11 - 1 = 10，即 f(11) = f(10) + 1，这里的 +1 就是我们取出的面额为 1 的硬币。
        //同理，如果取面额为 2 或面额为 5 的硬币可以得到：
        //f(11) = f(9) + 1
        //f(11) = f(6) + 1
        //f(11) = min(f(10), f(9), f(6)) + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void test() {
        int[] coins = {1, 2, 5};//7
        int[] coins1 = {186, 419, 83, 408};
//        System.out.println(coinChange(coins, 32));
        System.out.println(coinChange(coins1, 6249));
        System.out.println(coinChange2(coins1, 6249));
    }
}
