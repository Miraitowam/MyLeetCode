package LeetCode高频题目速刷.pakage2;

import org.junit.Test;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * @return:
 * @Author: M
 * @create: 2022/9/14 16:12
 */

public class Test17 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    @Test
    public void test() {
        String[] nums = {"3","9","20",null,null,"15","7"};
        TreeNode head = TreeNode.getHead(nums);
        System.out.println(levelOrder(head));
    }
}
