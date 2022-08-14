package 树;

import org.junit.Test;

/**
 * @description: 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，
 * 使得所有节点的值在[low, high]中。修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * @return:
 * @Author: M
 * @create: 2022/8/11 11:29
 */

public class Test20 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);
        //说明root是在范围内的无需修改
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    @Test
    public void test() {
        String[] root = {"3", "0", "4", null, "2", null, null, "1"};
        TreeNode head = TreeNode.getHead(root);

        TreeNode res = trimBST(head, 1, 3);
        TreeNode.printNodes(res);
    }
}
