package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:28
 */

public class Test22 {
    //首先定义一个解列表
    private char[] keys = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        backTracing(board, 0, 0);
        for (char[] keys : board) {
            for (char key : keys) {
                System.out.print(key + " ");
            }
            System.out.println(" ");
        }
    }

    //回溯法求解
    public boolean backTracing(char[][] board, int posX, int posY) {
        for (int i = posX; i < board.length; i++) {
            for (int j = posY; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                List nuns = canInput(board, i, j);
                if (nuns.isEmpty()) return false;
                for (int k = 0; k < nuns.size(); k++) {
                    board[i][j] = (char) nuns.get(k);
                    if (backTracing(board, posX, posY)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    //判断填入的数字是否有效
    public boolean isValid(char[][] board, int i, int j, char num) {
        //确保行只出现一次
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == num && board[i][k] != '.') {
                return false;
            }
        }
        //确保列只出现一次
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == num && board[k][j] != '.') {
                return false;
            }
        }
        //确保九宫格只出现一次
        for (int k = (i / 3) * 3; k < (i / 3) * 3 + 3; k++) {
            for (int l = (j / 3) * 3; l < (j / 3) * 3 + 3; l++) {
                if (board[k][l] == num && board[k][l] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    //判断还可以填入那些数字
    public List<Character> canInput(char[][] board, int i, int j) {
        List<Character> res = new ArrayList<>();
        for (int k = 0; k < 9; k++) {
            if (isValid(board, i, j, keys[k])) {
                res.add(keys[k]);
            }
        }
        return res;
    }


    @Test
    public void test() {
        char[][] board = {{'.', '.', '9', '7', '.', '6', '.', '.', '3'}, {'.', '.', '4', '.', '.', '.', '9', '.', '.'}, {
                '6', '8', '.', '.', '9', '3', '.', '.', '.'}, {'.', '.', '.', '8', '.', '1', '3', '9', '.'}, {
                '9', '1', '.', '.', '.', '.', '5', '.', '.'}, {'.', '4', '.', '.', '2', '.', '.', '.', '1'}, {
                '1', '.', '7', '9', '.', '.', '.', '4', '.'}, {'.', '2', '.', '.', '4', '.', '6', '.', '.'}, {
                '.', '.', '.', '6', '.', '.', '.', '7', '5'}};
        System.out.println(canInput(board, 0, 5));
        solveSudoku(board);
    }
}
