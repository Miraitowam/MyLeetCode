package LeetCode名企打卡.day2;

import org.junit.Test;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @return:
 * @Author: M
 * @create: 2022/8/14 14:13
 */

public class Test3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) return head;
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    //翻转左闭右开区域内的节点
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.getHead(nums);
        ListNode node = reverseKGroup(head, 2);
        ListNode.printNode(node);
    }
}
