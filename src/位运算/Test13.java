package 位运算;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * @return:
 * @Author: M
 * @create: 2022/8/2 20:30
 */

public class Test13 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i & (i - 1)]+1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
