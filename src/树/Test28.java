package 树;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * @return:
 * @Author: M
 * @create: 2022/8/12 15:22
 */

public class Test28 {
    private int min = Integer.MAX_VALUE;
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    //中序遍历
    public void getMin(TreeNode root, Stack<Integer> temp) {
        if (root == null) return;
        getMin(root.right, temp);
        min = Math.min(min, Math.abs(root.val - temp.peek()));
        temp.push(root.val);
        getMin(root.left, temp);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }

    @Test
    public void test() {
        String[] root = {"5", "3", "6", "2", "4", null, "7"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"236", "104", "701", null, "227", null, "911"};
        TreeNode head1 = TreeNode.getHead(root1);

        System.out.println(getMinimumDifference(head));
        System.out.println(getMinimumDifference(head1));
    }
}
