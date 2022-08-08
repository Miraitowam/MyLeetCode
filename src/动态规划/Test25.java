package 动态规划;

import org.junit.Test;

/**
 * @description: 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:34
 */

public class Test25 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //hold表示第i天持有股票得最大收益
        int[] hold = new int[len + 1];
        //unHold表示第i天不持有股票得最大收益
        int[] unHold = new int[len + 1];
        //第0天就持有股票表示为负数
        hold[0] = -prices[0];
        for (int i = 1; i <= len; i++) {
            //不持有股票也就是昨天就没有我今天没买或者昨天有我今天卖(需要支付手续费)
            unHold[i] = Math.max(unHold[i - 1], hold[i - 1] + prices[i - 1] - fee);
            //持有股票就是昨天就有今天不卖或者昨天没有今天才买的
            hold[i] = Math.max(hold[i - 1], unHold[i - 1] - prices[i - 1]);
        }
        //肯定是不持有股票收益最大，返回最后一天不持有
        return unHold[len];
    }

    @Test
    public void test() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices1 = {1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit(prices, 2));//8
        System.out.println(maxProfit(prices1, 3));//6
    }
}
