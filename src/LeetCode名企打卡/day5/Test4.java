package LeetCode名企打卡.day5;

import org.junit.Test;

/**
 * @description: 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * @return:
 * @Author: M
 * @create: 2022/8/21 16:41
 */

public class Test4 {
    public double myPow(double x, long n) {
        if (n == 0) return 1.0;
        else if (n < 0) return 1 / myPow(x, -n);
        else if (n % 2 == 0) return myPow(x * x, n / 2);
        else return x * myPow(x, n - 1);
    }

    @Test
    public void test() {
        System.out.println(myPow(2, -4));
    }
}
