package 树;

import org.junit.Test;

/**
 * @description: 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * @return:
 * @Author: M
 * @create: 2022/8/9 11:20
 */

public class Test6 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        //当前节点是叶子节点且值相等那么就返回
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        boolean has = false;
        //向左递归
        has |= hasPathSum(root.left, targetSum - root.val);
        //向右递归
        has |= hasPathSum(root.right, targetSum - root.val);
        return has;
    }

    @Test
    public void test() {
        String[] root = {"5", "4", "8", "11", null, "13", "4", "7", "2", null, null, null, "1"};
        TreeNode head = TreeNode.getHead(root);

        System.out.println(hasPathSum(head, 26));
    }
}
