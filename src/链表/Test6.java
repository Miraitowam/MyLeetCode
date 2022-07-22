package 链表;

import org.junit.Test;

/**
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @return:
 * @Author: M
 * @create: 2022/7/20 22:13
 */

public class Test6 {
    public class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //递归的写法
    public ListNode swapPairs(ListNode head) {
        //如果为空就直接返回
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        //递归处理其余的节点
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
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

    //获得链表
    ListNode getNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    //打印链表
    public void printNode(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            int k = cur.val;
            System.out.print(k + " ");
            cur = cur.next;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2,3,4};
        ListNode node = getNode(nums);
        printNode(reverse(node));
    }
}
