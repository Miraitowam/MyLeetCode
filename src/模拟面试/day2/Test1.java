package 模拟面试.day2;

import org.junit.Test;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * @return:
 * @Author: M
 * @create: 2022/8/19 15:45
 */

public class Test1 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    @Test
    public void test() {
        TreeNode head = TreeNode.getHead(new String[]{"1", null, "2", "3"});
        System.out.println(postorderTraversal(head));
    }
}
