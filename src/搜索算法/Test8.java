package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 417
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result的 2D 列表 ，其中result[i] = [ri, ci]表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * @return:
 * @Author: M
 * @create: 2022/7/12 16:57
 */

public class Test8 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //定义最后的答案
        List<List<Integer>> res = new ArrayList<>();
        //获得整个岛屿的长宽信息
        int row = heights.length, col = heights[0].length;
        //如果只有一个点直接返回
        if (Math.max(row, col) == 1) {
            res.add(Arrays.asList(0, 0));
            return res;
        }
        //定义该点是否被访问
        boolean[][] canReachP = new boolean[row][col];  //能否到达太平洋
        boolean[][] canReachA = new boolean[row][col];  //能否到达大西洋
        //先从太平洋沿岸开始搜索记录所有能够到达的点
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, canReachP);
        }
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, canReachP);
        }
        //再从大西洋沿岸开始搜索记录所有能到达的点
        for (int i = 0; i < row; i++) {
            dfs(heights, i, col - 1, canReachA);
        }
        for (int i = 0; i < col; i++) {
            dfs(heights, row - 1, i, canReachA);
        }
        //遍历所有点，都为true说明太平洋大西洋都能到达
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canReachA[i][j] == true && canReachP[i][j] == true) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        //返回结果
        return res;
    }

    //进行dfs搜索能够到达的点
    public void dfs(int[][] heights, int i, int j, boolean[][] canReach) {
        //如果已访问就返回
        if (canReach[i][j]) return;
        //将该点设置为已访问
        canReach[i][j] = true;
        //如果向左不越界且满足高度要求就向左递归
        if (!isOut(heights, i - 1, j) && heights[i][j] <= heights[i - 1][j]) {
            dfs(heights, i - 1, j, canReach);
        }
        //如果向右不越界且满足高度要求就向左递归
        if (!isOut(heights, i + 1, j) && heights[i][j] <= heights[i + 1][j]) {
            dfs(heights, i + 1, j, canReach);
        }
        //如果向上不越界且满足高度要求就向左递归
        if (!isOut(heights, i, j + 1) && heights[i][j] <= heights[i][j + 1]) {
            dfs(heights, i, j + 1, canReach);
        }
        //如果向下不越界且满足高度要求就向左递归
        if (!isOut(heights, i, j - 1) && heights[i][j] <= heights[i][j - 1]) {
            dfs(heights, i, j - 1, canReach);
        }
    }

    //判断是否越界
    public boolean isOut(int[][] heights, int i, int j) {
        //获得整个岛屿的长宽信息
        int row = heights.length, col = heights[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        int[][] heights = {{13}, {4}, {19}, {10}, {1}, {11}, {5}, {17}, {3}, {10}, {1}, {0}, {1}, {4}, {1}, {3}, {6},
                {13}, {2}, {16}, {7}, {6}, {3}, {1}, {9}, {9}, {13}, {10}, {9}, {10}, {6}, {2}, {11}, {17}, {13}, {0},
                {19}, {7}, {13}, {3}, {9}, {2}};
        System.out.println(pacificAtlantic(heights));
    }
}
