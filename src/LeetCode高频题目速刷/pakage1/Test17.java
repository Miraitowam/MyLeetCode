package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @return:
 * @Author: M
 * @create: 2022/9/4 17:02
 */

public class Test17 {
    public int orangesRotting(int[][] grid) {
        //先统计橘子的数量
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int rot = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    rot++;
                    queue.add(new int[]{i, j});
                }
            }
        }
        //如果没有腐烂橘子
        if (fresh != 0 && rot == 0) return -1;
        if (rot == 0 || fresh == 0) return 0;
        //待腐烂橘子的数量
        int count = 0;
        //分钟数
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                //向上
                if (cur[0] != 0 && grid[cur[0] - 1][cur[1]] == 1) {
                    count++;
                    queue.offer(new int[]{cur[0] - 1, cur[1]});
                    grid[cur[0] - 1][cur[1]] = 2;
                }
                //向下
                if (cur[0] != grid.length - 1 && grid[cur[0] + 1][cur[1]] == 1) {
                    count++;
                    queue.offer(new int[]{cur[0] + 1, cur[1]});
                    grid[cur[0] + 1][cur[1]] = 2;
                }
                //向左
                if (cur[1] != 0 && grid[cur[0]][cur[1] - 1] == 1) {
                    count++;
                    queue.offer(new int[]{cur[0], cur[1] - 1});
                    grid[cur[0]][cur[1] - 1] = 2;
                }
                //向右
                if (cur[1] != grid[0].length - 1 && grid[cur[0]][cur[1] + 1] == 1) {
                    count++;
                    queue.offer(new int[]{cur[0], cur[1] + 1});
                    grid[cur[0]][cur[1] + 1] = 2;
                }
            }
            if (count == fresh) break;
        }
        if (count == fresh) return minutes;
        else return -1;
    }

    @Test
    public void test() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
