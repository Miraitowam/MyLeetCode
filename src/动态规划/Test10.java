package 动态规划;

import org.junit.Test;

/**
 * @description: 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * @return:
 * @Author: M
 * @create: 2022/8/4 13:39
 */

public class Test10 {
    public int integerBreak(int n) {
        //dp_i表示i能取到的最大的乘积
        int[] dp = new int[n];
        dp[1] = 1;//n=2时
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                //进行比较，是分解i-j更大还是不分解
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j + 1)));
            }
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(integerBreak(10));
    }
}
