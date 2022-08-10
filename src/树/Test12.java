package 树;

import org.junit.Test;

/**
 * @description: 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度由它们之间的边数表示。
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * @return:
 * @Author: M
 * @create: 2022/8/10 15:16
 */

public class Test12 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int res = getMax(root, root);
        res = Math.max(res, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
        return res;
    }

    //以当前节点为根节点的最大长度
    public int getMax(TreeNode root, TreeNode curRoot) {
        if (curRoot == null) return 0;
        int left = 0, right = 0;
        if (curRoot.left != null && curRoot.left.val == curRoot.val) {
            left = getMax(root, curRoot.left) + 1;

        }
        if (curRoot.right != null && curRoot.right.val == curRoot.val) {
            right = getMax(root, curRoot.right) + 1;
        }
        if (curRoot == root) return left + right;
        else return Math.max(left, right);
    }

    @Test
    public void test() {
        String[] root = {"4", "4"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"5", "4", "5", "1", "1", "5"};
        TreeNode head1 = TreeNode.getHead(root1);

        String[] root2 = {"1", "4", "5", "4", "4", "5"};
        TreeNode head2 = TreeNode.getHead(root2);

        System.out.println(longestUnivaluePath(head2));
    }
}
