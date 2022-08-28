package 华为机考;
/**
 * @description: 买卖股票的最佳时机2
 * @return:
 * @Author: M
 * @create: 2022/8/28 14:33
 */

import org.junit.Test;

public class Test16 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
