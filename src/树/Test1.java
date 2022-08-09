package 树;

import org.junit.Test;


/**
 * @description:
 * @return:
 * @Author: M
 * @create: 2022/8/8 17:48
 */

public class Test1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        String[] nums = {"3", "9", "20", null, null, "15", "7"};
        TreeNode head = TreeNode.getHead(nums);
        System.out.println(maxDepth(head));
    }
}
