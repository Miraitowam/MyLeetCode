package 数学;

import org.junit.Test;

/**
 * @description: 最大公约数
 * @return:
 * @Author: M
 * @create: 2022/7/17 19:16
 */

public class Test2 {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    public void test() {
        System.out.println(10 % 5);
    }
}
