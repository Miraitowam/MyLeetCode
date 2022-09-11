package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为days的数组给出。每一项是一个从1到365的整数。
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为costs[0] 美元；
 * 一张 为期七天 的通行证售价为costs[1] 美元；
 * 一张 为期三十天 的通行证售价为costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：
 * 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回 你想要完成在给定的列表days中列出的每一天的旅行所需要的最低消费。
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * @return:
 * @Author: M
 * @create: 2022/9/3 15:48
 */

public class Test12 {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        //最大天数和最小天数，其余不考虑
        int maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 100];
        len--;
        for (int i = maxDay; i >= minDay; i--) {
            //当天买票和7天前买和30天前买
            if (i == days[len]) {
                len--;
                dp[i] = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i + 30] + costs[2]);
            } else dp[i] = dp[i + 1];    //不需要出门
        }
        return dp[minDay];
    }

    @Test
    public void test() {
        int[] days = {1, 4, 6, 7, 8, 365};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }
}
