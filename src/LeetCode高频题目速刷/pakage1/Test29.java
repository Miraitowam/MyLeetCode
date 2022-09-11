package LeetCode高频题目速刷.pakage1;

import org.junit.Test;
import 树.TreeNode;

import java.util.*;

/**
 * @description: 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * @return:
 * @Author: M
 * @create: 2022/9/7 14:22
 */

public class Test29 {
    List<TreeNode> res = new ArrayList<>();
    List<TreeNode> nodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        preorder(root);
        for (int i = 1; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(i).val == nodes.get(j).val) {
                    if (isSame(nodes.get(i), nodes.get(j))) {
                        if (!set.contains(nodes.get(i).val)) {
                            res.add(nodes.get(i));
                            set.add(nodes.get(i).val);
                        }
                    }
                }
            }
        }
        return res;
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        nodes.add(root);
        preorder(root.left);
        preorder(root.right);
    }

    public boolean isSame(TreeNode root, TreeNode p) {
        if (root == null && p == null) return true;
        if (root == null || p == null) return false;
        if (root.val != p.val) return false;
        boolean res = isSame(root.left, p.left);
        res &= isSame(root.right, p.right);
        return res;
    }

    @Test
    public void test() {
        String[] head = new String[]{"1", "2", "3", "4", null, "2", "4", null, null, "4"};
        String[] head1 = new String[]{"2", "1", "1"};
        TreeNode root = TreeNode.getHead(head);
        System.out.println(findDuplicateSubtrees(root));
    }
}
