package 图;

import org.junit.Test;

import java.util.*;

/**
 * @description: 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，
 * 表示在选修课程 ai 前 必须 先选修bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。
 * @return:
 * @Author: M
 * @create: 2022/7/26 23:05
 */

public class Test3 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //定义一个list记录顺序
        List<Integer> sequence = new ArrayList<>();
        //如果prerequisites为空那么就返回对应所有的课程
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) sequence.add(i);
            int[] res = sequence.stream().mapToInt(Integer::intValue).toArray();
            return res;
        }
        //定义一个数组表示每个节点的入度
        int[] inDeg = new int[numCourses];
        //定义一个队列储存当前节点
        Queue<Integer> queue = new LinkedList();
        //定义一个list存储依赖于当前这门课的课程
        List<Integer>[] pre = new List[numCourses];
        for (int i = 0; i < numCourses; i++) pre[i] = new ArrayList<>();
        //计算每个节点的入度
        for (int[] course : prerequisites) inDeg[course[0]]++;
        //计算依赖这门课的其他课
        for (int[] course : prerequisites) pre[course[1]].add(course[0]);
        //将入度为0的所有点都添加到队列
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) queue.offer(i);
        }
        //BFS
        while (!queue.isEmpty()) {
            //取出一门课进行分析
            for (int i = 0; i < queue.size(); i++) {
                int curCourse = queue.poll();   //拿到这门课
                sequence.add(curCourse);    //添加这门课
                if (!pre[curCourse].isEmpty()) {     //如果依赖这门课的课不为空
                    for (int course : pre[curCourse]) {
                        inDeg[course]--;    //依赖的这门课减少入度
                        if (inDeg[course] == 0) queue.offer(course);  //如果因此入度降低到了0,那么就添加
                    }
                }
            }
        }
        //搜索完毕之后返回
        int[] res = sequence.stream().mapToInt(Integer::intValue).toArray();
        return res.length == numCourses ? res : new int[]{};
    }

    @Test
    public void test() {
//        int[][] prerequisites = {{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}};
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[] res = findOrder(2, prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
