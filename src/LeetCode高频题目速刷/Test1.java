package LeetCode高频题目速刷;

import org.junit.Test;
import 树.ListNode;

/**
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * @return:
 * @Author: M
 * @create: 2022/9/1 16:30
 */

public class Test1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode listNode1 = reverse(l1);
        ListNode listNode2 = reverse(l2);
        ListNode res = addTwoNodes(listNode1, listNode2, 0);
        return res;
    }

    public ListNode addTwoNodes(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) return new ListNode(carry);
            else return null;
        }
        int left = l1 == null ? 0 : l1.val;
        int right = l2 == null ? 0 : l2.val;
        ListNode res = new ListNode((left + right + carry) % 10);
        carry = (left + right + carry) / 10;
        res.next = addTwoNodes(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return res;
    }

    public ListNode reverse(ListNode l1) {
        if (l1 == null || l1.next == null) return l1;
        ListNode temp = l1.next;
        ListNode pre = reverse(l1.next);
        temp.next = l1;
        l1.next = null;
        return pre;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.getHead(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.getHead(new int[]{9, 9, 9, 9});
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.printNodes(listNode);
    }
}
