package 树;

import org.junit.Test;

/**
 * @description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * @return:
 * @Author: M
 * @create: 2022/8/11 16:53
 */

public class Test22 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    //后序遍历实现
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.right);
        root.val += sum;
        sum = root.val;
        postOrder(root.left);
    }

    @Test
    public void test() {
        String[] root = {"4", "1", "6", "0", "2", "5", "7", null, null, null, "3", null, null, null, "8"};
        TreeNode head = TreeNode.getHead(root);

        convertBST(head);
        TreeNode.printNodes(head);
    }
}
