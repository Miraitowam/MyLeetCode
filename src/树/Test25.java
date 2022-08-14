package 树;

import org.junit.Test;

/**
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * @return:
 * @Author: M
 * @create: 2022/8/11 21:06
 */

public class Test25 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = dfs(nums, 0, nums.length - 1);
        return res;
    }

    //分治思想
    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    @Test
    public void test() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        TreeNode.printNodes(treeNode);
    }
}
