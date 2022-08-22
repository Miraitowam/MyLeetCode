package 树;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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

    //通过数组获得数的头结点
    public static TreeNode getHead(String[] nums) {
        if (nums[0] == null) return null;
        //创建节点
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null) treeNodes[i] = new TreeNode(Integer.parseInt(nums[i]));
        }
        //链接
        int left, right;
        //第多少个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (treeNodes[i] != null) {
                left = 2 * count + 1;
                right = 2 * count + 2;
                if (left < nums.length) treeNodes[i].left = treeNodes[left];
                if (right < nums.length) treeNodes[i].right = treeNodes[right];
                count++;
            }
        }
        return treeNodes[0];
    }

    //通过头结点打印节点BFS打印
    public static void printNodes(TreeNode head) {
        Queue<TreeNode> nodes = new LinkedList<>();
        //将头结点加入
        nodes.offer(head);
        //获取深度
        int dep = maxDepth(head);
        //BFS
        while (!nodes.isEmpty()) {
            if (dep == 0) break;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodes.poll();
                //打印当前节点
                if (curNode != null) System.out.print(curNode.val + " ");
                else System.out.print("null" + " ");
                if (curNode == null) continue;
                if (curNode.left != null) nodes.offer(curNode.left);
                else if (dep > 1) nodes.offer(null);
                if (curNode.right != null) nodes.offer(curNode.right);
                else if (dep > 1) nodes.offer(null);
            }
            dep--;
        }
    }

    //返回最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
