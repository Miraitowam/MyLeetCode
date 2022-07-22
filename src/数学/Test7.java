package 数学;

import org.junit.Test;

/**
 * @description: 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * @return:
 * @Author: M
 * @create: 2022/7/18 15:28
 */

public class Test7 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    @Test
    public void test(){
        System.out.println(trailingZeroes(5));
    }
}
