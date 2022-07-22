package 搜索算法;

import org.junit.Test;

/**
 * @description: 79
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/13 14:12
 */

public class Test11 {
    //定义一个变量表示找到否
    private boolean isFind = false;
    //定义棋盘的长宽
    private int row = 0;
    private int col = 0;

    public boolean exist(char[][] board, String word) {
        //如果棋盘为空直接返回
        if (board == null || board.length == 0) {
            return false;
        }
        //给棋盘的长宽赋值
        row = board.length;
        col = board[0].length;
        //记录该店是否被访问
        boolean[][] isVisited = new boolean[row][col];
        //对棋盘上每一个点都进行遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果找到了开头那么就遍历下去
                if (board[i][j] == word.charAt(0)) {
                    backTracing(board, word, isVisited, i, j, 0);
                }
                //如果找到了那就不需要再遍历下去
                if (isFind) break;
            }
        }
        return isFind;
    }

    //定义回溯法查询路径
    public void backTracing(char[][] board, String word, boolean[][] isVisited, int posX, int posY, int curLen) {
        //定义退出的条件：1.已访问 2.找到全部序列
        if (isVisited[posX][posY] || curLen == word.length()) {
            if (curLen == word.length()) {
                isFind = true;
            }
            return;
        }
        //如果当前的节点与要找的不同那就返回，相同那就把curLen+1
        if (board[posX][posY] == word.charAt(curLen)) {
            curLen++;
            if (word.length() == 1) {
                isFind = true;
            }
        } else {
            return;
        }
        //把当前节点标记为已访问
        isVisited[posX][posY] = true;
        //如果不越界就向左递归
        if (!isOut(posX - 1, posY)) {
            backTracing(board, word, isVisited, posX - 1, posY, curLen);
        }
        //如果不越界就向右递归
        if (!isOut(posX + 1, posY)) {
            backTracing(board, word, isVisited, posX + 1, posY, curLen);
        }
        //如果不越界就向上递归
        if (!isOut(posX, posY - 1)) {
            backTracing(board, word, isVisited, posX, posY - 1, curLen);
        }
        //如果不越界就向下递归
        if (!isOut(posX, posY + 1)) {
            backTracing(board, word, isVisited, posX, posY + 1, curLen);
        }
        //把当前节点设置为未访问
        isVisited[posX][posY] = false;
    }

    //定义是否越界
    boolean isOut(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        char board[][] = {{'A'}};
        String word = "A";
        System.out.println(exist(board, word));
    }
}
