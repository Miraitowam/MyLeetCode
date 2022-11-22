package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @return: 给定一个整数数组A，坡是元组(i, j)，其中i < j且A[i] <= A[j]。这样的坡的宽度为j - i。
 * 找出A中的坡的最大宽度，如果不存在，返回 0 。
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * @Author: M
 * @create: 2022/9/13 14:12
 */

public class Test15 {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        //坡底一定是在一个单调递减的队列中的
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int cur = stack.pop();
                res = Math.max(res, i - cur);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println(maxWidthRamp(nums));
    }
}
