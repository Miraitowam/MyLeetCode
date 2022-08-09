package 树;

import org.junit.Test;

/**
 * @description: 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * @return:
 * @Author: M
 * @create: 2022/8/9 11:39
 */

public class Test7 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        //包含自己在内
        res += pathSumStartWithRoot(root, targetSum);
        //向左递归
        res += pathSum(root.left, targetSum);
        //向右递归
        res += pathSum(root.right, targetSum);
        return res;
    }

    //dfs双重递归求解
    public int pathSumStartWithRoot(TreeNode root, long targetSum) {
        if (root == null) return 0;
        //如果当前节点是目标值那就返回 1
        int sum = 0;
        if (root.val == targetSum) sum++;
        //向左递归
        sum += pathSumStartWithRoot(root.left, targetSum - root.val);
        //向右递归
        sum += pathSumStartWithRoot(root.right, targetSum - root.val);
        return sum;
    }

    @Test
    public void test() {
        String[] root = {"10", "5", "-3", "3", "2", null, "11", "3", "-2", null, "1"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"5", "4", "8", "11", null, "13", "4", "7", "2", null, null, "5", "1"};
        TreeNode head1 = TreeNode.getHead(root1);

        System.out.println(pathSum(head, 8));
        System.out.println(pathSum(head1, 22));
    }
}
