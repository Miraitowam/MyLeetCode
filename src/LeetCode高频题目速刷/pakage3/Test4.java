package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

/**
 * @description: 剑指 Offer 63. 股票的最大利润
 * @return:
 * @Author: M
 * @create: 2022/10/17 16:24
 */

public class Test4 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int res = 0;
        for (int i = 2; i <= prices.length; i++) {
            dp[i] = dp[i - 1];
            for (int j = 1; j < i; j++) {
                if (prices[i - 1] > prices[j - 1]) dp[i] = Math.max(dp[i], prices[i - 1] - prices[j - 1]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] price = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(price));
    }
}
