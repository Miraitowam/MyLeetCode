package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

/**
 * @description: 粉碎糖果
 * 这个问题是实现一个简单的消除算法。
 * 给定一个 m x n 的二维整数数组 board 代表糖果所在的方格，不同的正整数 board[i][j] 代表不同种类的糖果，如果 board[i][j] == 0
 * 代表 (i, j) 这个位置是空的。
 * 给定的方格是玩家移动后的游戏状态，现在需要你根据以下规则粉碎糖果，使得整个方格处于稳定状态并最终输出：
 * 如果有三个及以上水平或者垂直相连的同种糖果，同一时间将它们粉碎，即将这些位置变成空的。
 * 在同时粉碎掉这些糖果之后，如果有一个空的位置上方还有糖果，那么上方的糖果就会下落直到碰到下方的糖果或者底部，这些糖果都是同时下落，
 * 也不会有新的糖果从顶部出现并落下来。
 * 通过前两步的操作，可能又会出现可以粉碎的糖果，请继续重复前面的操作。
 * 当不存在可以粉碎的糖果，也就是状态稳定之后，请输出最终的状态。
 * 你需要模拟上述规则并使整个方格达到稳定状态，并输出。
 * @return:
 * @Author: M
 * @create: 2022/11/22 16:10
 */

public class Test8 {
    public int[][] candyCrush(int[][] board) {
        //列
        int col = board[0].length;
        //行
        int row = board.length;
        //定义是否继续游戏
        boolean todo = false;
        //先行扫描，是否满足消除条件
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j >= 2) {
                    int v = Math.abs(board[i][j]);
                    if (v == 0) continue;
                    if (v == Math.abs(board[i][j - 1]) && Math.abs(board[i][j - 1]) == Math.abs(board[i][j - 2])) {
                        board[i][j] = -v;
                        board[i][j - 1] = -v;
                        board[i][j - 2] = -v;
                        todo = true;
                    }
                }
            }
        }
        //列扫描，是否满足消除条件
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j >= 2) {
                    int v = Math.abs(board[j][i]);
                    if (v == 0) continue;
                    if (v == Math.abs(board[j - 1][i]) && Math.abs(board[j - 1][i]) == Math.abs(board[j - 2][i])) {
                        board[j][i] = -v;
                        board[j - 1][i] = -v;
                        board[j - 2][i] = -v;
                        todo = true;
                    }
                }
            }
        }
        //如果满足消除条件
        if (todo) {
            //从左到右遍历每一列，满足条件就下坠
            int i = 0;
            while (i < col) {
                //下坠的初始点
                int start = 0;
                while (board[start][i] >= 0 && start + 1 < row) start++;
                //下坠的j距离
                int temp = start;
                while (temp < row && board[temp][i] < 0) temp++;
                if (temp == start) {
                    i++;
                    continue;
                }
                //处理下坠
                int step = temp - start;
                for (int j = start - 1; j >= 0; j--) {
                    board[j + step][i] = board[j][i];
                }
                for (int j = 0; j < step; j++) board[j][i] = 0;
                //检查这列是否处理完毕
                boolean flag = true;
                for (int j = 0; j < row; j++) flag = board[j][i] >= 0 && flag;
                if (flag) i++;
            }
        }
        return todo ? candyCrush(board) : board;
    }

    @Test
    public void test() {
        int[][] board = {{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314}, {410, 411, 412, 5, 414}, {
                5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714}, {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};
        int[][] res = candyCrush(board);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
