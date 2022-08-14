package 树;

import org.junit.Test;

/**
 * @description: 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * @return:
 * @Author: M
 * @create: 2022/8/12 10:51
 */

public class Test26 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        //快慢指针找到链表的中点
        ListNode pre = head;    //中点前的节点
        ListNode slow = pre.next;
        ListNode fast = slow == null ? null : slow.next;
        //循环结束之后慢指针指向
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode res = new TreeNode(slow.val);
        //分割链表
        pre.next = null;    //这样head节点就是左链表，slow.next就是右链表
        //处理左链表
        res.left = sortedListToBST(head);
        //处理右链表
        res.right = sortedListToBST(slow.next);
        return res;
    }

    @Test
    public void test() {
        ListNode head = ListNode.getHead(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode = sortedListToBST(head);
        TreeNode.printNodes(treeNode);
    }
}
