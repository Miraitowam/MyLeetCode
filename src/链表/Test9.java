package 链表;

import org.junit.Test;

/**
 * @description: 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * 返回一个由上述 k 部分组成的数组。
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * @return:
 * @Author: M
 * @create: 2022/7/21 14:13
 */

public class Test9 {
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        //首先要获得链表的长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        //说明长度为0
        if (len == 0) return null;
        //获得平均每段长度以及额外分配剩下的
        int average = len / k, plus = len % k;
        //对数量修正防止切的段数超过长度
        if (average == 0 && plus != 0) {
            average = 1;
            plus = 0;
        }
        ListNode[] res = new ListNode[k];
        cur = head;
        //开始切割
        for (int i = 0; cur != null && i < k; i++) {
            res[i] = cur;   //先把节点头放进去
            for (int j = 1; j < average; j++) cur = cur == null ? null : cur.next;
            //如果还有多余的部分那就追加一段
            if (plus-- > 0) cur = cur.next;
            //开始切割
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    @Test
    public void test() {
        int[] head = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode nodes = getNode(head);
        ListNode[] res = splitListToParts(nodes, 10);
        for (int i = 0; i < res.length; i++) {
            printNode(res[i]);
            System.out.println("");
            System.out.println("--------");
        }
    }
}
