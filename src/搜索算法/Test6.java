package 搜索算法;

import org.junit.Test;

/**
 * @description: 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 返回矩阵中 省份 的数量。
 * @return:
 * @Author: M
 * @create: 2022/7/10 20:23
 */

public class Test6 {
    public int findCircleNum(int[][] isConnected) {
        //获取城市数量
        int nums = isConnected.length;
        //标记这个城市是否被访问过
        boolean[] isVisited = new boolean[nums + 1];
        //定义省份数
        int CircleNum = 0;
        //遍历所有城市
        for (int i = 0; i < nums; i++) {
            //如果这个城市没有被访问
            if (!isVisited[i]) {
                getPro(isConnected, i, isVisited);
                CircleNum++;
            }
        }
        return CircleNum;
    }
    //DFS遍历所有节点
    public void getPro(int[][] isConnected, int i, boolean[] isVisited) {
        //如果该城市已访问那就return
        if (isVisited[i]) return;
        //获取与其连接的城市信息
        int[] msg = isConnected[i];
        for (int j = 0; j < msg.length; j++) {
            //找到所有连接的城市并标记为访问状态
            if (msg[j] == 1) {  //存在着连接
                //将这座城市设置为已访问，并继续递归下去
                isVisited[i] = true;
                getPro(isConnected, j, isVisited);
            }
        }
    }

    @Test
    public void test() {
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }
}

