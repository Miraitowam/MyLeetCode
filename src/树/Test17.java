package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * @return:
 * @Author: M
 * @create: 2022/8/11 10:43
 */

public class Test17 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }

    //递归实现前序遍历
    public void dfs(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    //非递归实现前序遍历
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node==null) continue;
            res.add(node.val);
            stack.push(node.right); //先右后左
            stack.push(node.left);
        }
    }


    @Test
    public void test() {
        String[] root = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(root);

        System.out.println(preorderTraversal(head));
    }
}
