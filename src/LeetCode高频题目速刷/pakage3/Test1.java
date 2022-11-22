package LeetCode高频题目速刷.pakage3;
/**
 * @description:
 * 二维数组是否出现某个单词
 * @return:
 * @Author: M
 * @create: 2022/10/12 17:29
 */

import org.junit.Test;

public class Test1 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (visited[x][y] || word.charAt(index) != board[x][y]) return false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (dfs(board, word, newX, newY, index + 1, visited)) return true;
        }
        visited[x][y] = false;
        return false;
    }

    @Test
    public void test() {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'B', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'A'}};
        System.out.println(exist(board, "A"));
    }
}
