package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * @return:
 * @Author: M
 * @create: 2022/8/11 11:08
 */

public class Test19 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return res;
    }

    //递归实现中序遍历
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    //非递归实现中序遍历
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {   //把所有左子节点都加入
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;   //再加入当前节点的右节点
        }
    }

    @Test
    public void test() {
        String[] root = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(root);

        System.out.println(inorderTraversal(head));
    }
}
