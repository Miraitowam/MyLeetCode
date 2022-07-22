package 数学;

import org.junit.Test;

/**
 * @description: 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @return:
 * @Author: M
 * @create: 2022/7/17 17:37
 */

public class Test1 {
    public int countPrimes(int n) {
        //定义一个标志位
        boolean isNotPrime[] = new boolean[n + 1];
        int count = 0;
        //开始遍历
        for (int i = 2; i < n; i++) {
            if (isNotPrime[i]) continue;
            count++;
            //标记质数的倍速
            for (long j = (long) i * i; j < n; j += i) {
                isNotPrime[(int) j] = true;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(100));
    }
}
