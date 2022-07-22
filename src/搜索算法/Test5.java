package 搜索算法;

import org.junit.Test;

/**
 * @description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * @Author: M
 * @create: 2022/7/10 19:53
 */

public class Test5 {
    public int numIslands(char[][] grid) {
        //定义一个变量表示岛屿数量
        int numIsland = 0;
        //遍历整个岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //找到陆地
                if (grid[i][j] == 1) {
                    numIsland++;    //表示找到一块岛屿
                    //标记陆地
                    getIslands(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    //DFS 求出岛屿数量
    public void getIslands(char[][] grid, int i, int j) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        //首先判断这块地是不是海洋是否越界，如果是都返回
        if (i < 0 || i > row || j < 0 || j > col || grid[i][j] == 0) return;
        //如果不是那就将自己标记为访问过也就是变为0，以免重复统计
        grid[i][j] = 0;
        //向左遍历
        getIslands(grid, i - 1, j);
        //向右遍历
        getIslands(grid, i + 1, j);
        //向上遍历
        getIslands(grid, i, j - 1);
        //向下遍历
        getIslands(grid, i, j + 1);
    }

    @Test
    public void test() {
        char[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(numIslands(grid));
    }
}

