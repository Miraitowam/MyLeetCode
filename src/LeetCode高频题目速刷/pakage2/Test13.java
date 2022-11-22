package LeetCode高频题目速刷.pakage2;

import org.junit.Test;
import 树.ListNode;

/**
 * @description: 给你一个链表的头节点 head 。
 * 链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。
 * 一个组的 长度 就是组中分配到的节点数目。换句话说：
 * 节点 1 分配给第一组
 * 节点 2 和 3 分配给第二组
 * 节点 4、5 和 6 分配给第三组，以此类推
 * 注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
 * 反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
 * 输入：head = [5,2,6,3,9,1,7,3,8,4]
 * 输出：[5,6,2,3,9,1,4,8,3,7]
 * 解释：
 * - 第一组长度为 1 ，奇数，没有发生反转。
 * - 第二组长度为 2 ，偶数，节点反转。
 * - 第三组长度为 3 ，奇数，没有发生反转。
 * - 最后一组长度为 4 ，偶数，节点反转。
 * @return:
 * @Author: M
 * @create: 2022/9/12 14:42
 */

public class Test13 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null) return head;
        ListNode index = head;
        int count = 1;
        ListNode pre = head;
        label:
        while (index != null) {
            if (count % 2 != 0) {
                int cnt = 0;
                for (int i = 0; i < count; i++) {
                    if (i == count - 1) pre = index;
                    index = index.next;
                    if (index != null) cnt++;
                }
            } else {
                ListNode tem = index;
                int k = count;
                while (k-- > 0) tem = tem.next;
                pre.next = reverse(index, count);
                index = tem;
            }
            count++;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int length) {
        ListNode pre = null, cur = head;
        while (length-- > 0 && cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode index = pre;
        while (index.next != null) index = index.next;
        index.next = cur;
        return pre;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 0, 6, 5};
        ListNode head = ListNode.getHead(nums);
        ListNode reverse = reverseEvenLengthGroups(head);
        ListNode.printNodes(reverse);
    }

}
