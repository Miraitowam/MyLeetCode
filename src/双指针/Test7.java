package 双指针;

import java.util.LinkedList;

/**
 * @description:
 * Given a linked list, determine if it has a cycle in it
 * @return:  
 * @Author: M 
 * @create: 2022/6/29 22:42
 */
 
public class Test7 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    private class ListNode {
        public ListNode next;
    }
}