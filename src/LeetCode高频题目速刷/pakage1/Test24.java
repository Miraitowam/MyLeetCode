package LeetCode高频题目速刷.pakage1;

import org.junit.Test;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * @return:
 * @Author: M
 * @create: 2022/9/6 10:43
 */

public class Test24 {
    List<TreeNode> children = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);
        int i = 0;
        for (TreeNode l : children) {
            if (l.val == p.val) if (i + 1 < children.size()) return children.get(i + 1);
            i++;
        }
        return null;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        children.add(root);
        inorder(root.right);
    }

    @Test
    public void test() {
        String[] root = {"2", "1", "3"};
        TreeNode head = TreeNode.getHead(root);
        TreeNode.printNodes(inorderSuccessor(head, new TreeNode(1)));
    }
}
