package 贪心算法;


/**
 * @description: Best Time to Buy and Sell Stock
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * @return:
 * @Author: M
 * @create: 2022/7/5 12:10
 */

public class Test5 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int buy = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[buy] > prices[i]) {
                buy = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[buy]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price));
    }
}
