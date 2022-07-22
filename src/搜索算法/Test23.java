package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:30
 */

public class Test23 {
    //定义结果集合
    List<List<String>> res = new ArrayList<>();
    //定义中间结果集
    List<String> tempRes = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //新建字符棋盘
        char[][] board = new char[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        //回溯法
        backTracing(board, 0, 0);
        return res;
    }

    //回溯法求解
    public boolean backTracing(char[][] board, int posX, int posY) {
        //退出的条件,已经添加了足够多的数据，此时返回false让循环继续下去否则只会返回一种可能性
        if (tempRes.size() == board.length) {
            res.add(new ArrayList<>(tempRes));
            return false;
        }
        //开始循环每一个可能的点
        for (int i = posX; i < board.length; i++) {
            for (int j = posY; j < board[0].length; j++) {
                if (isValid(board, i, j)) {     //如果这个点能放下Q那就试一试
                    board[i][j] = 'Q';
                    String tempString = String.valueOf(board[i]);
                    tempRes.add(tempString);
                    if (backTracing(board, i + 1, 0)) return true;    //放下之后如果能行就是一种解,从下一行开始
                    board[i][j] = '.';      //说明这个点不行，那就回溯
                    tempRes.remove(tempRes.size() - 1);
                }
            }
            //这一行都填完了都没返回肯定就不行
            return false;
        }
        return true;
    }

    //判断是否该位置有效
    public boolean isValid(char[][] board, int posX, int posY) {
        //检查列是否冲突
        for (int i = 0; i < board.length; i++) {
            if (board[i][posY] == 'Q') {
                return false;
            }
        }
        //检查行是否冲突
        for (int i = 0; i < board[0].length; i++) {
            if (board[posX][i] == 'Q') {
                return false;
            }
        }
        //检查左上方对角线是否冲突
        for (int i = posX - 1, j = posY - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查右上方是否有冲突
        for (int i = posX - 1, j = posY + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = {{'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}};
        System.out.println(isValid(board, 0, 0));
        System.out.println(solveNQueens(5));
    }
}
