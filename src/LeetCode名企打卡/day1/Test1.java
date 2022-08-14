package LeetCode名企打卡.day1;

import org.junit.Test;

/**
 * @description: 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @return:
 * @Author: M
 * @create: 2022/8/13 22:17
 */

public class Test1 {
    public int maxProfit(int[] prices) {
        //持有股票最大收益
        int[] hold = new int[prices.length + 1];
        //不持有股票最大收益
        int[] unHold = new int[prices.length + 1];
        hold[0] = -prices[0];
        for (int i = 1; i <= prices.length; i++) {
            //不持有股票就是昨天不持有和今天卖了
            unHold[i] = Math.max(unHold[i - 1], hold[i - 1] + prices[i - 1]);
            //持有股票就是昨天就有和今天才买
            hold[i] = Math.max(hold[i - 1], -prices[i - 1]);
        }
        return unHold[prices.length];
    }

    @Test
    public void test() {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }
}
