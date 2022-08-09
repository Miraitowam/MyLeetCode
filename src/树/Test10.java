package 树;

import org.junit.Test;

/**
 * @description: 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @return:
 * @Author: M
 * @create: 2022/8/9 17:05
 */

public class Test10 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //对应只有一个叶子节点的情况
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        //对应两个叶子结点都有
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        String[] root = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"2", null, "3", null, "4", null, "5", null, "6"};
        TreeNode head1 = TreeNode.getHead(root1);

        System.out.println(minDepth(head));
        System.out.println(minDepth(head1));
    }
}
