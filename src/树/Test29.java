package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @description: 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * @return:
 * @Author: M
 * @create: 2022/8/12 16:01
 */

public class Test29 {
    private int count = 1;
    private int maxCount = Integer.MIN_VALUE;
    private List<Integer> res = new ArrayList<>();
    private TreeNode preNode = null;

    //验证密码强度
    public boolean strongPasswordCheckerII(String password) {
        //正则表达式
        Pattern pattern = Pattern.compile("[!@#$%^&*()\\-+]");
        boolean res = pattern.matcher(password).find();
        if (!res) return false;
        //长度约束
        if (password.length() < 8) return false;
        char c;
        int lower = 0;
        int upper = 0;
        int num = 0;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            //至少包含小写
            if (c - 'a' >= 0 && c - 'a' < 26) lower++;
            //至少包含大写
            if (c - 'A' >= 0 && c - 'A' < 26) upper++;
            //至少包含数字
            if (c - '0' >= 0 && c - '0' < 10) num++;
            //没有连续重复
            if (i > 0) if (password.charAt(i - 1) == c) return false;
        }
        if (lower == 0 || upper == 0 || num == 0) return false;
        return true;
    }

    public int[] findMode(TreeNode root) {
        inOrder(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    //中序遍历求解
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.right);
        //如果当前值与前驱节点值相等计数器加1
        if (preNode != null) {
            if (preNode.val == root.val) count++;
            else count = 1;
        }
        //如果计数器的值更大那么就清空以前的
        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        } else if (count == maxCount) {     //如果恰好等于那么就添加
            res.add(root.val);
        }
        preNode = root;
        inOrder(root.left);
    }

    @Test
    public void test() {
        String[] root = {"1", null, "2", "2"};
        TreeNode head = TreeNode.getHead(root);
        int[] mode = findMode(head);
        for (int i : mode) {
            System.out.print(i + " ");
        }
    }
}
