package 动态规划;

import org.junit.Test;

/**
 * @description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:34
 */

public class Test26 {
    //有一串10万的数据执行时间过长
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //表示前i天发生过交易的最大值
        int sell = -1;
        //在这j天里会发生一次交易或者两次交易或者不交易
        for (int j = 1; j <= len; j++) {
            //最大值就是，交易，交易1次,交易两次
            sell = Math.max(sell, maxProfit(prices, 0, j) + maxProfit(prices, j, len));
        }
        return sell;
    }

    //返回指定天数内的最大收益
    //start:prices开始的下标->0开始
    //end:需要交易到的天数，比如交易到第3天就写3
    public int maxProfit(int[] prices, int start, int end) {
        if (start == prices.length) return 0;
        //buy表示第i天买入的最大收益
        int buy = 0;
        //sell表示第i天卖出的最大收益
        int sell = 0;
        //第start天就买入表示为负数
        buy = -prices[start];
        for (int i = start + 1; i <= end; i++) {
            buy = Math.max(buy, -prices[i - 1]);
            sell = Math.max(sell, prices[i - 1] + buy);
        }
        return sell;
    }

    public int maxProfit1(int[] prices) {
        //dp数组一共有5个维度，分别是不操作，第一次买入，第一次卖出，第二次买入，第二次卖出
        int[] dp = new int[5];
        //第一次买入初始化
        dp[1] = -prices[0];
        //第二次买入初始化
        dp[3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //如果这一天发生第一次买入那么就是取上一天为第一次买入时间和昨天没有今天买最大
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            //第一次卖出就是上一天为第一次卖出和第一次买入今天卖出最大
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            //第二次买入就是，上一天为第二次买入和上一天为第一次卖出今天买入
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            //第二次卖出就是，上一天为第二次卖出或者上一天为第二次买入今天卖出
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return dp[4];
    }

    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {0};
        System.out.println(maxProfit1(prices));//6
        System.out.println(maxProfit1(prices1));//4
        System.out.println(maxProfit1(prices2));//0
        System.out.println(maxProfit1(prices3));//0
    }
}
