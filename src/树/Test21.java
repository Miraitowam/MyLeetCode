package 树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * @return:
 * @Author: M
 * @create: 2022/8/11 15:28
 */

public class Test21 {
    private Stack<Integer> res = new Stack<>();
    private Stack<Integer> temp = new Stack<>();
    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    //递归加单调栈
    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        //如果比栈顶元素小那就一直弹出，因为栈底要放最小的元素，弹出的元素放在备选区
        while (!res.isEmpty() && root.val < res.peek()) temp.push(res.pop());
        //防止重复添加元素
        if (!res.contains(root.val)) res.push(root.val);
        //数不够k个就从备选区拿
        while (res.size() < k && !temp.isEmpty()) res.push(temp.pop());
        //数超了就再放到备选区
        while (res.size() > k) temp.push(res.pop());
        //左递归
        dfs(root.left, k);
        //右递归
        dfs(root.right, k);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    @Test
    public void test() {
        String[] root = {"3", "0", "4", null, "2", null, null, "1"};
        TreeNode head = TreeNode.getHead(root);
        System.out.println(kthSmallest(head, 2));
    }
}
