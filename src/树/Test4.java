package 树;

import org.junit.Test;

/**
 * @description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @return:
 * @Author: M
 * @create: 2022/8/9 10:43
 */


public class Test4 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //翻转左
        invertTree(root.left);
        //翻转右
        invertTree(root.right);
        return root;
    }

    @Test
    public void test() {
        String[] nums = {"4", "2", "7", "1", "3", "6", "9"};
        TreeNode head = TreeNode.getHead(nums);

        String[] nums1 = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head1 = TreeNode.getHead(nums1);

        TreeNode treeNode = invertTree(head);
        TreeNode.printNodes(treeNode);

        System.out.println();

        TreeNode treeNode1 = invertTree(head1);
        TreeNode.printNodes(treeNode1);
    }
}
