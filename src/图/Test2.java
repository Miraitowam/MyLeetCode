package 图;

import org.junit.Test;

import java.util.*;


/**
 * @description: 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * @return:
 * @Author: M
 * @create: 2022/7/26 22:57
 */

public class Test2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //如果不存在prerequisites那么就直接返回
        if (prerequisites.length == 0) return true;
        //定义一个数组记录所有节点的入度
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        //一个数组记录所有的预备课程
        List<Integer>[] pre = new List[numCourses];
        for (int i = 0; i < numCourses; i++) pre[i] = new ArrayList();
        //定义一个队列记录当前节点
        Queue<Integer> queue = new LinkedList();
        for (int[] course : prerequisites) {
            inDegree[course[0]]++;
            pre[course[1]].add(course[0]);  //      记录所有依赖此课程的课程
        }
        //让所有度为0的点入列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        //定义选课数
        int count = 0;
        //BFS
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                //选出一门课出来分析
                int curCourse = queue.poll();
                //选课数量加一
                count++;
                //拿到依赖这门课的后续课程
                if (!pre[curCourse].isEmpty()) {     //确实有其他课依赖于这门课
                    for (int nextCourse : pre[curCourse]) {
                        //那就将下一门课的入度减1
                        inDegree[nextCourse]--;
                        //如果减了之后导致度为0那么就把这门课添加到队列中
                        if (inDegree[nextCourse] == 0) queue.offer(nextCourse);
                    }
                }
            }
        }
        //最后比较选的课和目标值是否一致
        return count == numCourses;
    }

    @Test
    public void test() {
        //int[][] prerequisites = {{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}};
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites));
    }
}
