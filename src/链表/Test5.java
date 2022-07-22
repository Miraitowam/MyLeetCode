package 链表;

/**
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @return:
 * @Author: M
 * @create: 2022/7/20 21:25
 */

public class Test5 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        //如果为空返回null
//        if (head == null) return null;
//        //定义前驱结点当前节点
//        ListNode pre = head, cur = head;
//        //重新定义步数
//        int k = n + 1;
//        while (cur != null) {
//            //走了n步才开始同步走
//            if (k <= 0) pre = pre.next;
//            cur = cur.next;
//            k--;
//        }
//        //说明要删除头结点
//        if (pre == head) return head.next;
//        //删除pre前的节点
//        pre.next = pre.next.next;
//        return head;
        return null;
    }

//    //快慢指针
//    ListNode p1 = head;
//    ListNode p2 = head;
//    //快指针前进N步
//        while(n-- > 0){
//        p2 = p2.next;
//    }
//    //判断倒数第n个节点是不是头结点
//        if(p2 == null){
//        return head.next;
//    }
//    //判断倒数第n个节点不是头结点，找到倒数第n个节点的前一个节点
//        while(p2.next != null){
//        p2 = p2.next;
//        p1 = p1.next;
//    }
//    //删除倒数第n个节点
//    ListNode temp = (p1.next).next;
//    p1.next = temp;
//        return head;
}
