package 链表;
/**
 * @description:
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * @return:
 * @Author: M
 * @create: 2022/7/20 21:03
 */

public class Test4 {
    public class ListNode4 {
        int val;
        Test3.ListNodes next;

        ListNode4(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode4 deleteDuplicates(ListNode4 head){
//        //如果为空就直接返回
//        if(head == null) return null;
//        //定义游标
//        ListNode4 cur = new ListNode4(-1);
//        ListNode4 index = cur;
//        while(head != null && head.next!=null){
//            if(head.val != head.next.val) {
//                index.next = head;
//                index = index.next;
//            }
//            head = head.next;
//        }
//        if(head != null) index.next = head;
//        return cur.next;
        return null;
    }
}
