package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * @return:
 * @Author: M
 * @create: 2022/8/10 20:50
 */

public class Test15 {
    public List<Double> averageOfLevels(TreeNode root) {
        //要用到BFS首先定义一个队列
        Queue<TreeNode> queue = new LinkedList();
        //最终返回结果
        List<Double> res = new ArrayList<>();
        //每一层的平均
        Double average;
        //每一层计数
        int count;
        queue.offer(root);
        //每一层的大小
        int size;
        Double sum;
        //BFS
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0.0;
            count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                count++;
                sum += cur.val;
                //添加节点
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            average = sum / count;
            res.add(average);
        }
        return res;
    }

    @Test
    public void test() {
        String[] root = {"3","9","20",null,null,"15","7"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"3","9","20","15","7"};
        TreeNode head1 = TreeNode.getHead(root1);

        System.out.println(averageOfLevels(head));
        System.out.println(averageOfLevels(head1));
    }
}
