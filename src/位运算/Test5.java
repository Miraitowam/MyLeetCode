package 位运算;

import org.junit.Test;

/**
 * @description: 颠倒给定的 32 位无符号整数的二进制位。
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * @return:
 * @Author: M
 * @create: 2022/8/2 15:40
 */

public class Test5 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;   //左移一位空出位置
            res |= (n & 1);//提取最后一位并赋值
            n >>>= 1; //  无符号右移
        }
        return res;
    }

    @Test
    public void test() {
        int n = 43261596;
        System.out.println(reverseBits(n));
        System.out.println(Integer.reverse(n));
    }
}
