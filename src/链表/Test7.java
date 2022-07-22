package 链表;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * @return:
 * @Author: M
 * @create: 2022/7/21 10:38
 */

public class Test7 {
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

    //链表相加基于栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        //哨兵和游标
        ListNode head = new ListNode(-1);
        //进位
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            //判断是否为空，为空用0替代否则弹出
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            //生成相加后的节点
            ListNode cur = new ListNode(sum % 10);
            cur.next = head.next;
            head.next = cur;
            carry = sum / 10;
        }
        return head.next;
    }

    //生成节点栈
    public Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    //链表相加基于反转
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        ListNode head = new ListNode(-1);
        ListNode cur = null;
        int carry = 0;
        while (reverse1 != null || reverse2 != null || carry != 0) {
            int i = reverse1 == null ? 0 : reverse1.val;
            int j = reverse2 == null ? 0 : reverse2.val;
            int sum = (i + j + carry) % 10;
            carry = (i + j + carry) / 10;
            cur = new ListNode(sum);
            cur.next = head.next;
            head.next = cur;
            reverse1 = reverse1 == null ? null : reverse1.next;
            reverse2 = reverse2 == null ? null : reverse2.next;
        }
        return head.next;
    }

    //链表反转基于循环
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        //哨兵
        ListNode dum = new ListNode(-1);
        //游标
        ListNode cur = head;
        while (cur != null) {
            //首先存储next
            ListNode next = cur.next;
            cur.next = dum.next;
            dum.next = cur;
            cur = next;
        }
        return dum.next;
    }

    //链表反转基于递归
    public ListNode reverse2(ListNode head) {
        //退出条件
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode pre = reverse2(head.next);
        temp.next = head;
        head.next = null;
        return pre;
    }

    @Test
    public void test() {
        int[] nums1 = {2,4,3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = getNode(nums1);
        ListNode l2 = getNode(nums2);
        printNode(addTwoNumbers2(l1, l2));
    }
}
