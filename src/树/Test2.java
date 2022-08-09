package 树;

import org.junit.Test;

public class Test2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
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

        System.out.println(isBalanced(head));
        System.out.println(isBalanced(head1));
        System.out.println(isBalanced(head2));
        TreeNode.printNodes(head2);
    }
}
