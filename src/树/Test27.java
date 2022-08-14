package 树;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * 输出: true
 * @return:
 * @Author: M
 * @create: 2022/8/12 14:35
 */

public class Test27 {
    Set<Integer> set = new HashSet<>();
    boolean isFind = false;

    public boolean findTarget(TreeNode root, int k) {
        canFind(root, k);
        return isFind;
    }

    //在二叉搜索树中寻找某个数，找到返回true
    public void canFind(TreeNode root, int target) {
        if (root == null) return;
        canFind(root.right, target);
        set.add(root.val);
        if (set.contains(target - root.val) && root.val != target - root.val) isFind = true;
        canFind(root.left, target);
    }

    @Test
    public void test() {
        String[] root = {"5", "3", "6", "2", "4", null, "7"};
        TreeNode head = TreeNode.getHead(root);
        System.out.println(findTarget(head, 6));
    }
}
