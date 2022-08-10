package 树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 输入: root = [2,1,3]
 * 输出: 1
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * @return:
 * @Author: M
 * @create: 2022/8/10 21:08
 */

public class Test16 {
    public int findBottomLeftValue(TreeNode root) {
        //BFS定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        //添加首节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    @Test
    public void test() {
        String[] root = {"3","9","20",null,null,"15","7"};
        TreeNode head = TreeNode.getHead(root);

        System.out.println(findBottomLeftValue(head));
    }
}
