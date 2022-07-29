package 图;

import org.junit.Test;


import java.util.HashSet;
import java.util.Set;

/**
 * @description: 树可以看成是一个连通且 无环的无向图。
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，
 * 且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * @return:
 * @Author: M
 * @create: 2022/7/26 23:06
 */

//并查集解决
public class Test4 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 1005; //节点数量3-1000
        int[] father = init(n);
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1], father)) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1], father);
            }
        }
        return null;
    }

    //1020. 飞地的数量
    public int numEnclaves(int[][] grid) {
        //初始化并查集
        int size = grid.length * grid[0].length;  //多一个点表示边界点
        int[] father = init(size);
        boolean[] onEdge = new boolean[size];
        //拿到陆地
        int res = 0;
        //遍历每一个不为0的节点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int index = i * grid[0].length + j;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {   //如果下方为1就连接
                        join(index, index + grid[0].length, father);
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {   //如果右方为1就连接
                        join(index, index + 1, father);
                    }
                    if (isAlone(i, j, grid)) res++;

                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {  //将可以到达的所有的父节点都定义为可以到达
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                        int index = i * grid[0].length + j;
                        int f = find(index, father);
                        onEdge[f] = true;
                    }
                }
            }
        }
        Set set = new HashSet();
        for (int i = 0; i < father.length; i++) {
            if (father[i] != i) {
                if (onEdge[find(i, father)]) continue;   //如果父节点能到达说明全都能到达
                res++;
                set.add(find(i, father));
            }
        }
        //res中没有假如父节点
        return res + set.size();
    }

    //判断一个点是否是孤立的点
    boolean isAlone(int i, int j, int[][] grid) {
        if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length-1) return false;
        if (grid[i - 1][j] == 0 && grid[i + 1][j] == 0 && grid[i][j - 1] == 0 && grid[i][j + 1] == 0) return true;
        return false;
    }

    //并查集初始化
    public int[] init(int n) {
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;  //初始化将每个节点的父节点指向自己
        }
        return father;
    }

    //并查集寻找根
    int find(int u, int[] father) {
        return u == father[u] ? u : find(father[u], father);
    }

    //将某条边加入到并查集中
    void join(int u, int v, int[] father) {
        u = find(u, father);
        v = find(v, father);
        if (u == v) return;
        father[v] = u;
    }

    //判断u和v是同一根
    boolean same(int u, int v, int[] father) {
        u = find(u, father);
        v = find(v, father);
        return u == v;
    }

    @Test
    public void test() {
//        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
//        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        int[][] grid = {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 0, 1, 0, 0}, {
                0, 1, 1, 0, 0, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1, 1, 0, 1}, {
                0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 0}, {
                0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(numEnclaves(grid));
    }
}
