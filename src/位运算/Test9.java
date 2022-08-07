package 位运算;

import org.junit.Test;

/**
 * @description: 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * @return:
 * @Author: M
 * @create: 2022/8/2 16:38
 */

public class Test9 {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);   //自己与右移一位异或如果满足01应该得到全部都是1
        return (a & (a + 1)) == 0;
    }

    @Test
    public void test() {
        System.out.println(hasAlternatingBits(5));
    }
}
