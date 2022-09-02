package 图;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，
 * 其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于graph[u] 中的每个 v ，
 * 都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * 如果图是二分图，返回 true ；否则，返回 false 。
 * 输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * 输出：false
 * 解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
 * @return:
 * @Author: M
 * @create: 2022/7/25 22:01
 */

/*
 * 二分图说人话版：给定一幅「图」，用两种颜色将图中的所有顶点着色，且使得任意一条边的两个端点的颜色都不相同。
 * 其实二分图的判定问题就等同于图的【双色问题】，如果能够成功地将图染色，那么这幅图就是一幅二分图，反之则不是。
 * 如示例1，没有办法按照双色问题的标准染色，所以不是二分图；示例2可以将[0,2]染颜色A，[1,3]染颜色B，所以是二分图。
 */
public class Test1 {
    public int isBipartite(int[][] graph) {
        //创建颜色数组，由于图的表示用的是连接数
        int[] colors = new int[graph.length];
        //初始我们给所有的点都涂成一个颜色，用-1表示
        Arrays.fill(colors, -1);
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            //如果当前点标记为-1，就用dfs以当前节点进行遍历，走过一个节点就换个颜色标记，最后检查每条边两端颜色是否不同
            if (colors[i] == -1 && !traverse(i, 0, colors, graph))
                ;
        }
        return res;
    }

    //dfs进行遍历标记
    public boolean traverse(int start, int curColor, int[] colors, int[][] graph) {
        //首先将当前点的颜色标记为curColor
        colors[start] = curColor;
        //进行判断如果出现了相邻节点颜色相同就没必要遍历下去了
        for (int node : graph[start]) if (colors[start] == colors[node]) return false;
        //继续遍历下一个点,并更换颜色
        //与该节点连接的所有点
        for (int node : graph[start]) {
            if (colors[node] == -1) {    //表示该点还没有被访问
                if (!traverse(node, (curColor + 1) % 2, colors, graph))  //保证颜色只有三种：-1未访问0和1是两种颜色
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] graph = {{1}, {1,3}, {2,4}, {3,5}, {4,6}, {5,7},{6}};
        System.out.println(isBipartite(graph));
    }
}
