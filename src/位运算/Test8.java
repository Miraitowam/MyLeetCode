package 位运算;

import org.junit.Test;

/**
 * @description: 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * @return:
 * @Author: M
 * @create: 2022/8/2 16:28
 */

public class Test8 {
    public boolean isPowerOfFour(int n) {
        //确保只有一个1并且一定在奇数位上
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
    }

    @Test
    public void test() {
        System.out.println(isPowerOfFour(17));
    }
}
