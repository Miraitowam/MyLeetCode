package 链表;

/**
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @return:
 * @Author: M
 * @create: 2022/7/19 22:14
 */

public class Test2 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        Test1.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
        }
        return pre;
    }
}
