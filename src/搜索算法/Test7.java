package 搜索算法;

import org.junit.Test;

/**
 * @description: 130
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 输入：board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
 * 输出：[['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * @return:
 * @Author: M
 * @create: 2022/7/10 21:10
 */

public class Test7 {
    public void solve(char[][] board) {
        //首先对整个面板进行遍历找到一个'o'
        //先遍历边界点再内陆
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {     //表示找到了一块地
                    //分两种方式进行,如果是边界点那么就把连接区域都变成B,否则变成X
                    if (isBoarder(board, i, j)) {
                        dfs(board, i, j, 'b');
                    }
                }
            }
        }
        //单独处理中央
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {     //表示找到了一块地
                    //分两种方式进行,如果是边界点那么就把连接区域都变成B,否则变成X
                    dfs(board, i, j, 'i');
                }
            }
        }
        //处理完成进行变量替换，将'B'变回来
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    //使用dfs对面板进行填充
    public void dfs(char[][] board, int i, int j, char mode) {
        int row = board.length - 1;
        int col = board[0].length - 1;
        //退出条件如果越界或者为X那就退出
        if (i < 0 || i > row || j < 0 || j > col || board[i][j] == 'X' || board[i][j] == 'B') return;
        //如果不是边界上的'o'那就置位'x',否则置位B
        if (mode == 'b') {
            board[i][j] = 'B';
        } else {
            board[i][j] = 'X';
        }
        //向左遍历
        dfs(board, i - 1, j, mode);
        //向右遍历
        dfs(board, i + 1, j, mode);
        //向上遍历
        dfs(board, i, j - 1, mode);
        //向下遍历
        dfs(board, i, j + 1, mode);
    }

    //判断是否是边界上的'o'
    public boolean isBoarder(char[][] board, int i, int j) {
        int row = board.length - 1;
        int col = board[0].length - 1;
        if (i == 0 || i == row || j == 0 || j == col) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        char[][] board = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        solve(board);
        System.out.println(board);
    }
}
