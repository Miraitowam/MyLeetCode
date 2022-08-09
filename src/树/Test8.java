package 树;

import org.junit.Test;

/**
 * @description: 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot
 * 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * @return:
 * @Author: M
 * @create: 2022/8/9 15:41
 */

public class Test8 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        //先找到头结点都相同的节点
        boolean res;
        res = isOrNot(root, subRoot);
        res |= isSubtree(root.left, subRoot);
        res |= isSubtree(root.right, subRoot);
        return res;
    }

    //节点比对
    public boolean isOrNot(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        boolean res = true;
        //入果当前节点相等，那么从左到右依次比较
        //向左递归
        res &= isOrNot(root.left, subRoot.left);
        //向右递归
        res &= isOrNot(root.right, subRoot.right);
        return res;
    }

    @Test
    public void test() {
        //{"3", "4", "5", "1", "2"}
        //{"3","4","5","1","2",null,null,null,null,"0"}
        String[] root = {"1"}, subRoot = {"0"};
        TreeNode head = TreeNode.getHead(root), subHead = TreeNode.getHead(subRoot);
        System.out.println(isSubtree(head, subHead));
    }
}
