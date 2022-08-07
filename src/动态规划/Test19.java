package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * @return:
 * @Author: M
 * @create: 2022/8/6 17:09
 */

public class Test19 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp_ijk表示考虑前k个字符串有i个0和j个1组成的最大子集长度
        int[][] dp = new int[m + 1][n + 1];
        //统计每个字符串1的个数
        int countOnes;
        int countZeros;
        for (String str : strs) {
            //每次循环都重新赋值
            countOnes = 0;
            countZeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') countOnes++;
                else countZeros++;
            }
            //dp数组复用逆序
            for (int i = m; i >= countZeros; i--) {
                for (int j = n; j >= countOnes; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countZeros][j - countOnes] + 1);
                }
            }
        }
        return dp[m][n];
    }


    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
}
