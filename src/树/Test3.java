package 树;

import org.junit.Test;

/**
 * @description: 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @return:
 * @Author: M
 * @create: 2022/8/8 21:01
 */

public class Test3 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left + right, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    //求最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        String[] nums = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(nums);

        String[] nums1 = {"1", "2", "2", "3", "3", null, null, "4", "4"};
        TreeNode head1 = TreeNode.getHead(nums1);

        String[] nums2 = {"1", "2", "2", "3", null, null, "3", "4", null, null, "4"};
        TreeNode head2 = TreeNode.getHead(nums2);

        System.out.println(diameterOfBinaryTree(head));
        System.out.println(diameterOfBinaryTree(head1));
        System.out.println(diameterOfBinaryTree(head2));
    }
}
