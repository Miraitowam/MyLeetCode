package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 * @return:
 * @Author: M
 * @create: 2022/8/3 22:55
 */

public class Test7 {
    public int uniquePaths(int m, int n) {
        //如果是长条状的必然只有一条路
        if (m == 1 || n == 1) return 1;
        //dp_ij表示到达该点有多少条路径
        int[][] dp = new int[m][n];
        //初始化
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 7));
    }
}
