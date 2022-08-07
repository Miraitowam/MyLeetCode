package 动态规划;

import org.junit.Test;

public class Test6 {
    public int minPathSum(int[][] grid) {
        //如果grid是长条形那就返回和
        if (grid.length == 1 || grid[0].length == 1) {
            int sum = 0;
            for (int[] row : grid) {
                for (int n : row) sum += n;
            }
            return sum;
        }
        //dp_ij表示当前格子能够拿到的最小的和
        int[][] dp = new int[grid.length][grid[0].length];
        //初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < grid[0].length; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        //开始循环
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
