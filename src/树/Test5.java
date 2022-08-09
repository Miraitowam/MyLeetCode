package 树;

import org.junit.Test;

/**
 * @description: 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：
 * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * @return:
 * @Author: M
 * @create: 2022/8/9 10:54
 */

public class Test5 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode res;
        if (root1 == null) res = new TreeNode(root2.val);
        else if (root2 == null) res = new TreeNode(root1.val);
        else res = new TreeNode(root1.val + root2.val);
        //向左递归
        res.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        //向右递归
        res.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return res;
    }

    @Test
    public void test() {
        String[] root1 = {"1", "3", "2", "5"};
        TreeNode head1 = TreeNode.getHead(root1);

        String[] root2 = {"2", "1", "3", null, "4", null, "7"};
        TreeNode head2 = TreeNode.getHead(root2);

        TreeNode.printNodes(mergeTrees(head1, head2));
    }
}
