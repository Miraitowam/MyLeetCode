package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * @return:
 * @Author: M
 * @create: 2022/8/4 22:22
 */

public class Test14 {
    public int findLongestChain(int[][] pairs) {
        //dp_i表示当前i能够连接的最多的数组
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[][] pairs = {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
//        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        System.out.println(findLongestChain(pairs));
    }
}
