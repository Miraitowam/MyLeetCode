package LeetCode高频题目速刷.pakage1;

import org.junit.Test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * @return:
 * @Author: M
 * @create: 2022/9/7 15:30
 */

public class Test30 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        //先添加窗口
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) queue.pollLast();
            queue.offerLast(nums[i]);
            if (i >= k && nums[i - k] == queue.peekFirst()) queue.pollFirst();
            if (i >= k - 1) ans[index++] = queue.peek();
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
