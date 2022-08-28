package 华为机考;

import org.junit.Test;

import java.util.LinkedList;

public class Test10 {
    //走四方（上下左右）
    int[] positionX = new int[]{-1, 1, 0, 0};
    int[] positionY = new int[]{0, 0, 1, -1};
    LinkedList<int[]> queue;

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        queue = new LinkedList<>();
        label:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    //找到第一座岛屿后，将这座岛屿周围的水域加入队列后，跳出
                    break label;
                }
            }
        }
        int res = 0;
        //此时队列中存有第一个岛屿的周围水域
        while (!queue.isEmpty()) {
            res++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int k = 0; k < 4; k++) {
                    int newX = x + positionX[k];
                    int newY = y + positionY[k];
                    //越界或已访问的不能入队
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 2) {
                        continue;
                    }
                    //找到第二座岛，直接返回
                    if (grid[newX][newY] == 1) return res;
                    //还没找到第二座岛屿，加入队列继续 bfs
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = 2;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        //已访问的地方设为 2
        grid[x][y] = 2;
        for (int k = 0; k < 4; k++) {
            int newX = x + positionX[k];
            int newY = y + positionY[k];
            // 越界或已访问
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 2) {
                continue;
            }
            // 收集岛屿周围的水域，水域不需要继续 dfs，直接加入队列
            if (grid[newX][newY] == 0) {
                //防止 BFS 重复访问
                grid[newX][newY] = 2;
                queue.offer(new int[]{newX, newY});
                continue;
            }
            //岛屿部分继续 dfs
            dfs(grid, newX, newY);
        }
    }

    @Test
    public void test() {
        int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge(A));
    }
}
