package 分治;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * @return:
 * @Author: M
 * @create: 2022/7/8 13:58
 */

public class Test2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = build(1, n);
        return res;
    }

    private List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new ArrayList();
        if (l < r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftNodes = build(l, i - 1);
            List<TreeNode> rightNodes = build(i + 1, r);
            for (int j = 0; j < leftNodes.size(); j++) {
                for (int k = 0; k < rightNodes.size(); k++) {
                    TreeNode root = new TreeNode(i, leftNodes.get(j), rightNodes.get(k));
                    res.add(root);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        generateTrees(3);
    }
}
