package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:35
 */

public class Test27 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        //dp0表示不操作，后面分别是第1次买入第一次卖出第二次买入。。。
        int[] dp = new int[2 * k + 1];
        //为每一次买入初始化
        for (int i = 1; i < dp.length; i += 2) dp[i] = -prices[0];
        //先遍历的是天数
        for (int i = 1; i < prices.length; i++) {
            //再更新每一个状态
            for (int j = 1; 2 * j < dp.length; j++) {
                //买入的操作也就是我上一次就买了和我上一次卖出状态这一次买了取最大值
                dp[2 * j - 1] = Math.max(dp[2 * j - 1], dp[2 * j - 2] - prices[i]);
                //卖出额操作也就是我上一次卖出和这一次卖出的最大值
                dp[2 * j] = Math.max(dp[2 * j], dp[2 * j - 1] + prices[i]);
            }
        }
        //返回最后一次卖出的最大值
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        int[] prices = {3, 2, 6, 5, 0, 3, 35, 2, 6, 5, 0, 34, 8, 6, 5, 0, 3};
        System.out.println(maxProfit(7, prices));
    }
}
