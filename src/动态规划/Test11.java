package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * @return:
 * @Author: M
 * @create: 2022/8/4 14:21
 */

public class Test11 {
    public int numSquares(int n) {
        //拿到平方数
        List<Integer> squares = getSquare(n);
        //dp定义为i最少的平方数
        int[] dp = new int[n];
        dp[0] = 1;  //对应n=1
        for (int i = 1; i < n; i++) {
            dp[i] = i + 1;  //先给赋一个都是由1组成的值
            for (int sq : squares) {
                if (sq >= i + 1) {
                    //说明输入的i本身就是平方数
                    if (sq == i + 1) dp[i] = 1;
                    break;
                }
                //比较是前一个数加1更小还是一个个拆成小平方数更小
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }
        return dp[n - 1];
    }

    //生成平方数
    public List<Integer> getSquare(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;    //当前值
        int carry = 3;  //公差
        while (cur <= n) {
            res.add(cur);
            cur += carry;
            carry += 2;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(numSquares(13));
    }
}
