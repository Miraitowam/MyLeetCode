package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，
 * 他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * @return:
 * @Author: M
 * @create: 2022/9/3 17:12
 */

public class Test14 {
    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        return dfs(dungeon, 0, 0) + 1;
    }

    //用dfs解决
    public int dfs(int[][] dungeon, int x, int y) {
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) return Math.max(1 - dungeon[x][y], 1);
        if (memo[x][y] > 0) return memo[x][y];
        int minRes = 0;
        //撞墙只能往一个方向走
        if (x == dungeon.length - 1) {
            minRes = Math.max(dfs(dungeon, x, y + 1) - dungeon[x][y], 1);
        } else if (y == dungeon[0].length - 1) {
            minRes = Math.max(dfs(dungeon, x + 1, y) - dungeon[x][y], 1);
        } else {
            minRes = Math.max(Math.min(dfs(dungeon, x + 1, y), dfs(dungeon, x, y + 1)) - dungeon[x][y], 1);
        }
        return memo[x][y] = minRes;
    }

    //dp解决
    public int calculateMinimumHP1(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        //这个数组表示在i,j位置骑士需要的最小生命值
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) { //终点的情况
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == row - 1) { //最后一行的情况
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == col - 1) { //最后一列的情况
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[][] dungeon = {{-2, -2, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP1(dungeon));
    }
}
