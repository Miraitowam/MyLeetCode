package 搜索算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:22
 */

public class Test12 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        //定义一个list用来返回结果
        List<String> res = new ArrayList<>();
        //定义一个buffer记录中间结果
        StringBuffer tempRes = new StringBuffer();
        //DFS遍历得到结果
        backTracing(res, tempRes, root);
        return res;
    }
    //回溯法求解
    private void backTracing(List<String> res, StringBuffer tempRes, TreeNode root) {
        //定义退出的条件：1.当前节点为空
        if (root == null) return;
        //去出本节点的值
        String part = String.valueOf(root.val);
        //如果buffer空就拼接
        if (!tempRes.isEmpty()) {
            part = "->" + part;
        }
        //将part添加到temp中
        tempRes.append(part);
        //如果遍历到根节点
        if (root.left == null && root.right == null) {
            //添加结果
            res.add(tempRes.toString());
        }
        //向左递归
        backTracing(res,tempRes,root.left);
        //向右递归
        backTracing(res,tempRes,root.right);
        //删除part
        tempRes.delete(tempRes.length()-part.length(),tempRes.length());
    }
}
