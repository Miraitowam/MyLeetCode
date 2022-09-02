package LeetCode高频题目速刷;
/**
 * @description:
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @return:
 * @Author: M
 * @create: 2022/9/2 15:46
 */

import org.junit.Test;
import java.util.PriorityQueue;

public class Test5 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minTop = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) minTop.add(nums[i]);
            else {
                if (!minTop.isEmpty() && nums[i] > minTop.peek()) {
                    minTop.poll();
                    minTop.offer(nums[i]);
                }
            }
        }
        return minTop.peek();
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
