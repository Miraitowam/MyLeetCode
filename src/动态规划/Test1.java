package 动态规划;

import org.junit.Test;

/**
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * @return:
 * @Author: M
 * @create: 2022/8/2 21:54
 */

public class Test1 {
    int climbStairs(int n) {
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }

    @Test
    public void test() {
        System.out.println(climbStairs(5));
    }
}
