package 动态规划;

import org.junit.Test;

/**
 * @description: 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 * @return:
 * @Author: M
 * @create: 2022/8/3 22:40
 */

public class Test5 {
    public int countCow(int n) {
        if (n == 3) return n;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) dp[i] = i;
        for (int i = 4; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 3];
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(countCow(25));
    }
}
