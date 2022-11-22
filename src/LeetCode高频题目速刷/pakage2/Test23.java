package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

public class Test23 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        int leftIndex = left, rightIndex = right;
        int pivot = nums[(left + right) / 2];      //基准值
        while (leftIndex < rightIndex) {
            while (nums[leftIndex] < pivot) leftIndex++;
            while (nums[rightIndex] > pivot) rightIndex--;
            if (leftIndex >= rightIndex) break; //退出条件
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            if (nums[leftIndex] == pivot) rightIndex--;
        }
        if (leftIndex < right) quickSort(nums, leftIndex + 1, right);
        if (rightIndex > left) quickSort(nums, left, rightIndex - 1);
    }

    @Test
    public void test() {
        int[] nums = {-2,3,-5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
