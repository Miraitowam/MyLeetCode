package 数学;

import org.junit.Test;

/**
 * @description: 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * 输入：n = 27
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/18 17:15
 */

public class Test13 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    @Test
    public void test() {
        System.out.println(isPowerOfThree(28));
    }
}
