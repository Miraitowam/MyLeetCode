package 树;

import org.junit.Test;

public class Test24 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果为空或者root等于任意一方那么就返回
        if (root == null || root.val == p.val || root.val == q.val) return root;
        //在左右子树同时找两个节点，先找到谁就返回谁，要是没找到一定返回的是null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果都不为空就说明是根节点
        if (left != null && right != null) return root;
        //否则谁不为空就一定是谁
        return left == null ? right : left;
    }

    @Test
    public void test() {
        String[] root = {"6", "2", "8", "0", "4", "7", "9", null, null, "3", "5"};
        TreeNode head = TreeNode.getHead(root);

        TreeNode treeNode = lowestCommonAncestor(head, new TreeNode(7), new TreeNode(9));
        System.out.println(treeNode.val);
    }
}
