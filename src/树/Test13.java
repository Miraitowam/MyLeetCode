package 树;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * @return:
 * @Author: M
 * @create: 2022/8/10 16:17
 */

public class Test13 {
    private Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    //dfs搜索
    public int dfs(TreeNode root, boolean canStolen) {
        //设置退出条件：偷到底了或者当前这家不可以偷
        if (root == null) return 0;
        if (!canStolen) return dfs(root.left, true) + dfs(root.right, true);
        if (cache.containsKey(root)) return cache.get(root);
        //如果是当前家不可偷那么下一家是可以偷的
        //一共有两种选择，偷当前家或者不偷
        //偷当前家，那么这一家连接着的所有子节点都不可以偷
        int stolen = dfs(root.left, false) + dfs(root.right, false);
        //不偷当前家
        int unStolen = dfs(root.left, true) + dfs(root.right, true);
        //返回偷或者不偷当前家的最大值
        int res = Math.max(stolen + root.val, unStolen);
        cache.put(root, res);
        return res;
    }

    @Test
    public void test() {
        String[] root = {"3", "2", "3", null, "3", null, "1"};
        TreeNode head = TreeNode.getHead(root);

        String[] root1 = {"3", "4", "5", "1", "3", null, "1"};
        TreeNode head1 = TreeNode.getHead(root1);

        String[] root2 = {"79",
                "99", "77", null, null, null, "69", null, "60", "53", null, "73", "11", null, null, null, "62", "27", "62",
                null, null, "98", "50", null, null, "90", "48", "82", null, null, null, "55", "64", null, null,
                "73", "56", "6", "47", null, "93", null, null, "75", "44", "30", "82", null, null, null, null, null,
                null, "57", "36", "89", "42", null, null, "76", "10", null, null, null, null, null, "32", "4", "18",
                null, null, "1", "7", null, null, "42", "64", null, null, "39", "76", null, null, "6", null, "66",
                "8", "96", "91", "38", "38", null, null, null, null, "74", "42", null, null, null, "10", "40", "5", null,
                null, null, null, "28", "8", "24", "47", null, null, null, "17", "36", "50", "19", "63", "33", "89", null, null,
                null, null, null, null, null, null, "94", "72", null, null, "79", "25", null, null, "51", null, "70", "84",
                "43", null, "64", "35", null, null, null, null, "40", "78", null, null, "35", "42", "98", "96", null, null, "82", "26",
                null, null, null, null, "48", "91", null, null, "35", "93", "86", "42", null, null, null, null, "0", "61", null,
                null, "67", null, "53", "48", null, null, "82", "30", null, "97", null, null, null, "1", null, null};
        TreeNode head2 = TreeNode.getHead(root2);

        System.out.println(rob(head2));
    }
}
