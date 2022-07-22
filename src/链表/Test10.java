package 链表;

import org.junit.Test;

/**
 * @description: 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * @return:
 * @Author: M
 * @create: 2022/7/21 14:16
 */

public class Test10 {
    //节点
    public class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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

    public ListNode oddEvenList(ListNode head) {
        //满足条件直接返回
        if (head == null || head.next == null) return head;
        //定义奇数头、偶数头以及最后返回的头
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    @Test
    public void test() {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        ListNode head = getNode(nums);
        printNode(oddEvenList(head));
    }
}
