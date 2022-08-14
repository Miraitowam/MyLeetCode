package 树;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * @return:
 * @Author: M
 * @create: 2022/8/11 19:21
 */

public class Test23 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        boolean left = canFind(root.left, p) && canFind(root.left, q);
        boolean right = canFind(root.right, p) && canFind(root.right, q);
        if (!left && !right) return root;
        if (left) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    //从某个节点为父节点出发能否找到目标节点
    public boolean canFind(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return canFind(root.left, target) || canFind(root.right, target);
    }

    //利用二叉树特性
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //如果都比根节点大那么一定在右子树
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        //如果都比根节点小那么一定在左子树
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        //反之一大一小，那么根节点一定是最近
        return root;
    }

    @Test
    public void test() {
        String[] root = {"6", "2", "8", "0", "4", "7", "9", null, null, "3", "5"};
        TreeNode head = TreeNode.getHead(root);

        TreeNode treeNode = lowestCommonAncestor1(head, new TreeNode(7), new TreeNode(9));
        System.out.println(treeNode.val);
    }
}
