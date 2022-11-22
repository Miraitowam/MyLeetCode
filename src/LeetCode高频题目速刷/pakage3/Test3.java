package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 60. n个骰子的点数
 * @return:
 * @Author: M
 * @create: 2022/10/17 15:15
 */

public class Test3 {
    public double[] dicesProbability(int n) {
        //前i个色子凑出j的概率
        double[][] dp = new double[n + 1][6 * n + 1];
        //先求出一个色子凑出1-6点数的概率
        Arrays.fill(dp[1], 1 / 6.0);
        //先遍历色子，再遍历点数，点数从色子的个数n开始
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                //增加一个色子摇到k的概率相当于少一个色子，摇到k-（1-6）的概率之和再乘1/6
                Double temp = 0.0;
                for (int k = 1; k <= 6; k++) {
                    //防止越界
                    if (j - k <= 0 || j - k > 6 * (i - 1)) continue;
                    temp += dp[i - 1][j - k];
                }
                dp[i][j] = temp / 6;
            }
        }
        double[] ans = new double[6 * n - (n - 1)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[n][i + n];
        }
        return ans;
    }

    @Test
    public void test() {
        dicesProbability(2);
    }
}
