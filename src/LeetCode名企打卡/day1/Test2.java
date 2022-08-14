package LeetCode名企打卡.day1;

import java.util.Random;

/**
 * @description: 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * 实现 Solution 类：
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 * @return:
 * @Author: M
 * @create: 2022/8/13 22:27
 */

public class Test2 {
    ListNode head;
    Random random;

    public void Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    // 蓄水池算法
    // 第一次拿第一个数 第一个数的概率是100%
    // 第二次 拿第二个数 取第二个数的概率是50%
    // 第三次 拿第三个数是 33% 则保留原本数的概率是66%
    public int getRandom() {
        ListNode p = this.head;
        int count = 0;
        int res = 0;
        while (p != null) {
            count++;
            int randomInt = random.nextInt(count) + 1;
            //如果等于count那么就能被抽到否则抽不到
            if (randomInt == count) res = p.val;
            p = p.next;
        }
        return res;
    }
}
