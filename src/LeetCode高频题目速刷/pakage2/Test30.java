package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @return:
 * @Author: M
 * @create: 2022/10/12 15:43
 */

public class Test30 {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int res = (dp[i - 1] + dp[i - 2]) % ((int) 1e9 + 7);
            dp[i] = res;
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numWays(45));
    }
}
