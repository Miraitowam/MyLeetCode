package 链表;

import org.junit.Test;

/**
 * @description: 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/21 14:11
 */

public class Test8 {
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

    public boolean isPalindrome(ListNode head) {
        //首先用快慢指针定位到链表的中点
        ListNode fast = head;
        ListNode slow = head;
        //fast走两步slow一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果不为空说明链表长度为奇数
        if (fast != null) slow = slow.next;
        //此时slow所在的节点恰好是中点那么就反转剩下的部分
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            //比较节点值是否相等
            if (slow.val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //链表反转递归
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
        int[] nums = {1,2};
        ListNode head = getNode(nums);
        System.out.println(isPalindrome(head));
    }
}
