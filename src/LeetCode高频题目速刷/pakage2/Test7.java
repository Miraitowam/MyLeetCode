package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含n个节点的树，标记为0到n - 1 。给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * @return:
 * @Author: M
 * @create: 2022/9/11 14:50
 */

public class Test7 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] inDegree = new int[n];    //记录每一个节点的入度
        List<Integer>[] depend = new List[n];
        for (int i = 0; i < depend.length; i++) depend[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
            depend[edges[i][1]].add(edges[i][0]);
            depend[edges[i][0]].add(edges[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的加入
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                for (int j = 0; j < depend[cur].size(); j++) {
                    inDegree[depend[cur].get(j)]--;
                    if (inDegree[depend[cur].get(j)] == 1) queue.offer(depend[cur].get(j));
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] edges = {{5, 6}, {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(findMinHeightTrees(7, edges));
    }
}
