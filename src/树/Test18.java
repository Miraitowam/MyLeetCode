package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * @return:
 * @Author: M
 * @create: 2022/8/11 10:55
 */

public class Test18 {
    List<Integer> res = new ArrayList<>();

    //前序遍历的顺序为root->left->right
    //可以修改前序遍历顺序为:root->right->left
    //这样取反就是后序遍历：left->right->root
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        Collections.reverse(res);
        return res;
    }

    //递归实现后序遍历
    public void dfs(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.right);
        dfs(root.left);
    }

    //非递归实现后序遍历
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.left); //先左后右这样先出来的就是右
            stack.push(node.right);
        }
    }

    @Test
    public void test() {
        String[] root = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(root);

        System.out.println(postorderTraversal(head));
    }
}
