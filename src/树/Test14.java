package 树;

import org.junit.Test;


/**
 * @description: 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * @return:
 * @Author: M
 * @create: 2022/8/10 19:18
 */

public class Test14 {
    private long minValue[] = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (minValue[1] != Long.MAX_VALUE) return Math.toIntExact(minValue[1]);
        return -1;
    }

    //dfs
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val < minValue[0] && root.val < minValue[1]) minValue[0] = root.val;
        if (root.val > minValue[0] && root.val < minValue[1]) minValue[1] = root.val;
        dfs(root.left);
        dfs(root.right);
    }

    @Test
    public void test() {
        String[] root = {"2", "2", "2147483647"};
        TreeNode head = TreeNode.getHead(root);
        System.out.println(findSecondMinimumValue(head));
    }
}
