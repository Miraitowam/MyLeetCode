package 树;

import org.junit.Test;

/**
 * @description: 给定二叉树的根节点 root ，返回所有左叶子之和。
 * @return:
 * @Author: M
 * @create: 2022/8/10 14:42
 */

public class Test11 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    //是否是叶子节点
    private boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }

    @Test
    public void test() {
        String[] root = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"2", null, "3", null, "4", null, "5", null, "6"};
        TreeNode head1 = TreeNode.getHead(root1);

        String[] root2 = {"1", "2", "3", "4", "5"};
        TreeNode head2 = TreeNode.getHead(root2);

        System.out.println(sumOfLeftLeaves(head));
        System.out.println(sumOfLeftLeaves(head1));
        System.out.println(sumOfLeftLeaves(head2));
    }
}
