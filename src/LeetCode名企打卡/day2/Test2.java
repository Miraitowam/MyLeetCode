package LeetCode名企打卡.day2;

import org.junit.Test;
import 链表.Test6;

/**
 * @description: 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @return:
 * @Author: M
 * @create: 2022/8/14 13:45
 */

public class Test2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //链表完全反转,递归写法
    public ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode temp = head.next;
        ListNode pre = reverse(head.next);
        temp.next = head;
        head.next = null;
        return pre;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.getHead(nums);
        ListNode node = reverseList(head);
        ListNode.printNode(node);
    }
}
