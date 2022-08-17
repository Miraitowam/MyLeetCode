package LeetCode名企打卡.day3;

import org.junit.Test;

/**
 * @description: 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @return:
 * @Author: M
 * @create: 2022/8/17 11:04
 */

public class Test2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = null;
        for (ListNode cur : lists) {
            res = merge(res, cur);
        }
        return res;
    }

    //先写一个能够合并两个链表的函数
    public ListNode merge(ListNode listNodeA, ListNode listNodeB) {
        if (listNodeA == null && listNodeB == null) return null;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (listNodeA != null || listNodeB != null) {
            //如果有一个为null那就等于不为null的那个
            if (listNodeA == null || listNodeB == null) {
                if (listNodeA == null) {
                    res.next = listNodeB;
                    listNodeB = listNodeB.next;
                } else {
                    res.next = listNodeA;
                    listNodeA = listNodeA.next;
                }
            } else {  //否则都不为空就比大小
                if (listNodeA.val > listNodeB.val) {
                    res.next = listNodeB;
                    listNodeB = listNodeB.next;
                } else {
                    res.next = listNodeA;
                    listNodeA = listNodeA.next;
                }
            }
            res = res.next;
        }
        return cur.next;
    }

    @Test
    public void test() {
        ListNode listNodeA = ListNode.getHead(new int[]{1, 4, 5});
        ListNode listNodeB = ListNode.getHead(new int[]{1, 3, 4});
        ListNode res = merge(listNodeA, listNodeB);
        ListNode.printNode(res);
    }
}
