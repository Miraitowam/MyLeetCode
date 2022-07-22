package 贪心算法;

import javax.swing.*;

/**
 * @description: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * @return:
 * @Author: M
 * @create: 2022/7/5 13:08
 */

public class Test6 {
    // hold[i][j]: 对于0~i天中最多进行j次交易并且第i天仍然持有股票的收益
    // unhold[i][j]: 对于0~i天中最多进行j次交易并且第i天不持有股票的收益
    // 第i天持有股票的收益为 之前买了股票但还没有卖出 或者 今天才选择买入股票 二者中较大值
    // hold[i][j] = Math.max(unhold[i-1][j]-prices[i],hold[i-1][j]);
    // 第i天不持有股票的收益为 选择今天卖出 或者 今天不买入时 最大的收益
    // unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) {
            return 0;
        }
        if (k > prices.length / 2) {
            return noLimit(prices);
        }
        int[][] hold = new int[k + 1][prices.length];
        int[][] unHold = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            //假设第一次购买股票
            hold[i][0] = -prices[0];
            //假设第一次不持有股票
            unHold[i][0] = 0;
            //开始计算最大收益
            for (int j = 1; j < prices.length; j++) {
                hold[i][j] = Math.max(-prices[j] + unHold[i - 1][j], hold[i][j - 1]); // Buy or not buy
                unHold[i][j] = Math.max(prices[j] + hold[i][j - 1], unHold[i][j - 1]); // Sell or not sell
            }
        }
        return unHold[k][prices.length - 1];
    }

    private static int noLimit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i + 1] == prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(2, price));
    }
}
