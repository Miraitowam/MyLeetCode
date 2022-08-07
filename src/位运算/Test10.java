package 位运算;

import org.junit.Test;

/**
 * @description: 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * @return:
 * @Author: M
 * @create: 2022/8/2 16:47
 */

public class Test10 {
    public int findComplement(int num) {
        if (num == 1) return 0;
        int mask = 0;//掩码
        while ((mask & num) != num) mask = ((mask | 1) << 1) | 1; //获得与num长度一致的1
        return num ^ mask;
    }

    @Test
    public void test() {
        System.out.println(findComplement(8));
    }
}
