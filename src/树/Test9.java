package 树;

import org.junit.Test;

/**
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * @return:
 * @Author: M
 * @create: 2022/8/9 16:49
 */

public class Test9 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    //判断是否对称
    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        boolean res = true;
        //比较外面
        res &= isSymmetric(t1.left, t2.right);
        //比较里面
        res &= isSymmetric(t1.right, t2.left);
        return res;
    }

    @Test
    public void test() {
        String[] root = {"1", "2", "2", null, "3", null, "3"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"1", "2", "2", "3", "4", "4", "3"};
        TreeNode head1 = TreeNode.getHead(root1);

        System.out.println(isSymmetric(head));
        System.out.println(isSymmetric(head1));
    }
}
