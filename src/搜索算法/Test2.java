package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 279
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * @return:
 * @Author: M
 * @create: 2022/7/10 14:45
 */

public class Test2 {
    public int numSquares(int n) {
        //返回所有比N小的平方数
        List<Integer> squares = generateSquares(n);
        //创造一个队列用来存储遍历的节点
        Queue<Integer> nodes = new LinkedList<>();
        //创造一个数组标记已经遍历的节点
        boolean[] isVisited = new boolean[n + 1];
        //将n置位已访问状态，并且将n加入到节点中
        isVisited[n] = true;
        nodes.offer(n);
        //记录路径层数
        int level = 0;
        //只要不为空就一直遍历
        while (!nodes.isEmpty()) {
            //每一层需要遍历的次数
            int size = nodes.size();
            level++;
            while (size-- > 0) {            //取出队列头的元素，并让层数加1
                int cur = nodes.poll();

                //让该元素分别与平方数相减，若是等于0就存在通路
                for (int square : squares) {
                    int next = cur - square;
                    if (next < 0) {
                        break;
                    }
                    //恰好为0刚好到达，无需继续遍历
                    if (next == 0) {
                        return level;
                    }
                    //如果下一个值被遍历过了那就不需要添加到队列
                    if (isVisited[next]) {
                        continue;
                    }
                    //如果没有被遍历也不满足以上条件那么就继续遍历下去
                    isVisited[next] = true;
                    nodes.offer(next);
                }
            }
        }
        return level;
    }

    public List<Integer> generateSquares(int n) {
        //返回集合
        List<Integer> squares = new ArrayList<>();
        //添加初始元素
        int init = 1;
        squares.add(init);
        //差值
        int diff = 3;
        //只要小于就不断产生
        while (init < n) {
            init += diff;
            squares.add(init);
            diff += 2;  //更新diff
        }
        return squares;
    }

    @Test
    public void test() {
        System.out.println(numSquares(55));
    }
}
