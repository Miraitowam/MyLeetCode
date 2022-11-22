package LeetCode高频题目速刷.pakage2;

import 树.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，
 * maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * 输入：head = [5,3,1,2,5,1,2]
 * 输出：[1,3]
 * 解释：存在三个临界点：
 * - [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
 * - [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
 * - [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
 * 第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
 * 第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
 * @return:
 * @Author: M
 * @create: 2022/9/12 14:14
 */

public class Test12 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head, cur = head.next;
        if (cur.next == null) return new int[]{-1, -1};
        ListNode next = cur.next;
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (next != null) {
            if (cur.val < pre.val && cur.val < next.val) list.add(index);
            if (cur.val > pre.val && cur.val > next.val) list.add(index);
            index++;
            pre = pre.next;
            cur = cur.next;
            next = next.next;
        }
        if (list.size() < 2) return new int[]{-1, -1};
        int[] sub = new int[list.size() - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sub.length; i++) {
            sub[i] = list.get(i + 1) - list.get(i);
            min = Math.min(sub[i], min);
        }
        return new int[]{min, list.get(list.size() - 1) - list.get(0)};
    }

}
