package LeetCode高频题目速刷.pakage2;

/**
 * @description: 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 * @return:
 * @Author: M
 * @create: 2022/9/13 20:28
 */

public class Test16 {
    public boolean isValidSudoku(char[][] board) {
        //记录某一行某个数字是否被摆放
        boolean[][] row = new boolean[9][9];
        //记录某一列某个数字是否被摆放
        boolean[][] col = new boolean[9][9];
        //记录3*3的宫格内某个数是否被摆放
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int blockIndex = i / 3 * 3 + j / 3;
                int num = c - '1';
                if (row[i][num] || col[j][num] || block[blockIndex][num]) return false;
                else {
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blockIndex][num] = true;
                }
            }
        }
        return true;
    }
}
