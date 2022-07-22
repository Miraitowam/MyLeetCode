package 搜索算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * @return:
 * @Author: M
 * @create: 2022/7/10 10:46
 */

public class Test1 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //获取行列数
        int row = grid.length, col = grid[0].length;
        //如果起点或者终点是1那么本身就不可达
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        //创建方向矩阵
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        //创建队列记录当前节点位置,是坐标信息xy
        Queue<int[]> pos = new LinkedList<>();
        //将起点加入队列，加入的是坐标
        pos.offer(new int[]{0, 0});
        //将前向通路的距离储存在grid中，初始化起点走了1步
        grid[0][0] = 1;
        //只要pos不为空说明还有节点没有遍历到，只要当前节点没有到达终点就没有形成最短路径
        while (!pos.isEmpty()) {
            //取一个点出来参与搜索
            int[] xy = pos.poll();  //弹出队列头的元素并删除
            //记录前向距离
            int preLen = grid[xy[0]][xy[1]];
            //在八个方向搜索
            for (int i = 0; i < 8; i++) {
                //创建一个新的可能的点
                int newX = xy[0] + direction[i][0];
                int newY = xy[1] + direction[i][1];
                //对这个点进行判断,如果没有越过边界,并且是可以通过的
                if (!isCrossBorder(newX, newY, row, col) && grid[newX][newY] == 0) {
                    //那就把这个点加入到pos中
                    pos.offer(new int[]{newX, newY});
                    //存储距离
                    grid[newX][newY] = preLen + 1;
                }
            }
        }
        //BFS结束，有可能到达终点也有可能没有到达
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    //编写一个判断坐标是否越界的函数
    public boolean isCrossBorder(int x, int y, int row, int col) {
        if (x < 0 || x > row - 1 || y < 0 || y > col - 1) {
            return true;
        }
        return false;
    }

    @Test
    public void Mytest() {
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
