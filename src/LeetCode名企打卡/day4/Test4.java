package LeetCode名企打卡.day4;

import org.junit.Test;


/**
 * @description: 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * @return:
 * @Author: M
 * @create: 2022/8/17 14:49
 */

public class Test4 {
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        //分成前后两个部分
        ListNode mid = getMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        //head是前，temp是后
        temp = reverse(temp);
        merge(head, temp);
        ListNode.printNode(head);
    }

    //合并两条链表
    public void merge(ListNode head, ListNode temp) {
        if (temp == null) return;
        ListNode cur = temp;
        ListNode curNext = temp.next;
        ListNode curHead = head;
        ListNode headNext = head.next;
        while (cur != null) {
            curHead.next = cur;
            cur.next = headNext;
            curHead = headNext;
            cur = curNext;
            curNext = curNext == null ? null : curNext.next;
            headNext = headNext.next;
        }
    }

    //快慢指针找到中点切割
    public ListNode getMid(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    //翻转链表
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode pre = reverse(head.next);
        temp.next = head;
        head.next = null;
        return pre;
    }

    @Test
    public void test() {
        ListNode head = ListNode.getHead(new int[]{1, 2, 3, 4, 5, 6, 7});
        reorderList(head);
    }
}
