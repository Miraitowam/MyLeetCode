package 搜索算法;

import org.junit.Test;

/**
 * @description: 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直的四个方向上相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * @return:
 * @Author: M
 * @create: 2022/7/10 19:18
 */

public class Test4 {
    public int maxAreaOfIsland(int[][] grid) {
        //定义一个变量表示最大的岛屿面积
        int maxArea = 0;
        //遍历整个岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //找到陆地
                if (grid[i][j] == 1) {
                    //算出局部最大值
                    int Area = getArea(grid, i, j);
                    maxArea = Math.max(Area, maxArea);
                }
            }
        }
        return maxArea;
    }

    //DFS 求出最大的面积
    public int getArea(int[][] grid, int i, int j) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        //首先判断这块地是不是海洋是否越界，如果是都返回0
        if (i < 0 || i > row || j < 0 || j > col || grid[i][j] == 0) return 0;
        //如果不是那就将自己标记为访问过也就是变为0，以免重复统计
        grid[i][j] = 0;
        //定义面积
        int Area = 1;
        //向左遍历
        Area += getArea(grid, i - 1, j);
        //向右遍历
        Area += getArea(grid, i + 1, j);
        //向上遍历
        Area += getArea(grid, i, j - 1);
        //向下遍历
        Area += getArea(grid, i, j + 1);
        //返回最终的面积
        return Area;
    }

    @Test
    public void test() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
