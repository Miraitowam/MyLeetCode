package 位运算;

import org.junit.Test;

/**
 * @description: 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * @return:
 * @Author: M
 * @create: 2022/8/2 14:41
 */

public class Test1 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);   //取异或
    }

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
}
