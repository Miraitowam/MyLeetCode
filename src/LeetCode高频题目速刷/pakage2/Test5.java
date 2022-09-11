package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * @return:
 * @Author: M
 * @create: 2022/9/10 21:59
 */

public class Test5 {
    public void nextPermutation(int[] nums) {
        int target = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                target = i;
                break;
            }
        }
        if (target == -1) {     //说明本身就是降序排序的
            swap(nums, -1, nums.length);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[target]) {
                int temp = nums[i];
                nums[i] = nums[target];
                nums[target] = temp;
                break;
            }
        }
        //翻转后续
        swap(nums, target, nums.length);
    }

    public void swap(int[] nums, int start, int end) {
        int left = start + 1, right = end - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 7, 4, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
