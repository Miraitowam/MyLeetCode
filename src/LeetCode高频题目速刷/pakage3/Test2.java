package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

/**
 * @description: 剑指 Offer 14- I. 剪绳子
 * @return:
 * @Author: M
 * @create: 2022/10/12 17:29
 */

public class Test2 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(dp[j] * dp[i - j], Math.max(dp[j] * (i - j), j * (i - j)));
                dp[i] = Math.max(temp, dp[i]);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
    }
}
