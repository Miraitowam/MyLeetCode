package 动态规划;

import org.junit.Test;

/**
 * @description: 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:33
 */

public class Test24 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //hold表示第i天持有股票的最大收益
        int[] hold = new int[len + 1];
        //unHold表示第i天不持有股票的最大收益
        int[] unHold = new int[len + 1];
        //cool表示第i天冷静期的最大收益
        int[] cool = new int[len + 1];
        //第0天就持有股票表示欠钱
        hold[0] = -prices[0];
        for (int i = 1; i <= len; i++) {
            //若今天是冷冻期,也就是昨天有股票我今天卖出
            cool[i] = hold[i - 1] + prices[i - 1];
            //不持有就是昨天是冷冻期我今天没操作或者今天没买
            unHold[i] = Math.max(unHold[i - 1], cool[i - 1]);
            //持有就是昨天也有股票，我今天不操作或者昨天没有我今天买入
            hold[i] = Math.max(hold[i - 1], unHold[i - 1] - prices[i - 1]);
        }
        //返回三者中最大值
        return Math.max(cool[len], Math.max(hold[len], unHold[len]));
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 0, 2};     //3
        System.out.println(maxProfit(prices));
    }
}
