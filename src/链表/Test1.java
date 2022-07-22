package 链表;


/**
 * @description: 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * @return:
 * @Author: M
 * @create: 2022/7/19 21:19
 */

public class Test1 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //定义双指针
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA.next == null ? headB : pA.next;
            pB = pB.next == null ? headA : pB.next;
        }
        return pA;
    }
}
