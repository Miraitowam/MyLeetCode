package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

/**
 * @description: 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @return:
 * @Author: M
 * @create: 2022/9/15 14:58
 */

public class Test25 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int top = obstacleGrid[i - 1][j];
                int left = obstacleGrid[i][j - 1];
                if (top == 1 && left == 1) dp[i][j] = 0;
                else if (top == 1 && left == 0) dp[i][j] = dp[i][j - 1];
                else if (top == 0 && left == 1) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {


    }

    @Test
    public void test() {

        int[][] obstacleGrid = {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
