package LeetCode高频题目速刷.pakage3;

import org.junit.Test;

/**
 * @description: 面试题13. 机器人的运动范围
 * @return:
 * @Author: M
 * @create: 2022/10/17 16:38
 */

public class Test5 {
    public int movingCount(int m, int n, int k) {
        boolean[][] canReach = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = i, right = j;
                int bound = 0;
                while (left != 0) {
                    bound += left % 10;
                    left /= 10;
                }
                while (right != 0) {
                    bound += right % 10;
                    right /= 10;
                }
                if (bound <= k) canReach[i][j] = true;
            }
        }
        return dfs(canReach, 0, 0);
    }

    public int dfs(boolean[][] canReach, int posX, int posY) {
        if (posX < 0 || posY < 0 || posX >= canReach.length || posY >= canReach[0].length) return 0;
        if (!canReach[posX][posY]) return 0;
        int ans = 1;
        canReach[posX][posY] = false;
        ans += dfs(canReach, posX + 1, posY);
        ans += dfs(canReach, posX - 1, posY);
        ans += dfs(canReach, posX, posY + 1);
        ans += dfs(canReach, posX, posY - 1);
        return ans;
    }

    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 1));
    }
}
