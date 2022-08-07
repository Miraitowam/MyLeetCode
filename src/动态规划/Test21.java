package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * @return:
 * @Author: M
 * @create: 2022/8/7 10:57
 */

public class Test21 {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 0;
        //dp数组表示的是amount=dp_i时的方案数
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //初始化
        //最小的钱只有一种方案
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /*
     *给你一个整数数组 cookies ，
     * 其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，
     * 所有 零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。分发的 不公平程度
     * 定义为单个孩子在分发过程中能够获得饼干的最大总数。返回所有分发的最小不公平程度。
     * 输入：cookies = [8,15,10,20,8], k = 2
     * 输出：31
     * */
    private int[] kids;    //表示第k个小孩拿到的数量
    private int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        kids = new int[k];
        return dfs(cookies, cookies.length - 1);
    }

    //dfs
    public int dfs(int[] cookies, int cookieIndex) {
        //退出条件是所有饼干分完
        if (cookieIndex < 0) {
            //返回所有小孩中最大的饼干数
            return Arrays.stream(kids).max().getAsInt();
        }
        for (int i = 0; i < kids.length; i++) {
            //第i个孩子开始分饼干,如果分了饼干之后超过了已经记录的最优值那么这次就没必要进行下去了
            if (kids[i] + cookies[cookieIndex] > res) continue;
            kids[i] += cookies[cookieIndex];
            res = Math.min(dfs(cookies, cookieIndex - 1), res);
            //回溯，把饼干放回去
            kids[i] -= cookies[cookieIndex];
        }
        return res;
    }

    @Test
    public void test() {
        int[] coins = {4, 2, 5};
        System.out.println(change(1, coins));
        //分发饼干
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 3;
        System.out.println(distributeCookies(cookies, k));
    }
}
