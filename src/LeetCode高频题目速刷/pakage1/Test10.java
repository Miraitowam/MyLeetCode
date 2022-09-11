package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 * @return:
 * @Author: M
 * @create: 2022/9/2 21:08
 */

public class Test10 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        int i = mergeSort(nums, temp, 0, nums.length - 1);
        return i;
    }

    int mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int lp = mergeSort(nums, temp, left, mid);  //左边的逆序数
        int rp = mergeSort(nums, temp, mid + 1, right); //右边的逆序数
        int leftStart = left, rightStart = mid + 1; //左右两个数组开始的部分
        int crossPairs = 0;
        for (int i = left; i <= right; i++) {
            if (leftStart == mid + 1) temp[i] = nums[rightStart++];
            else if (rightStart == right + 1) temp[i] = nums[leftStart++];
            else if (nums[leftStart] <= nums[rightStart]) temp[i] = nums[leftStart++];
            else {
                temp[i] = nums[rightStart++];
                crossPairs += mid - leftStart + 1;
            }

        }
        //把归并了的部分传回原数组
        for (int i = left; i <= right; i++) nums[i] = temp[i];
        return lp + crossPairs + rp;
    }

    @Test
    public void test() {
        int[] nums = {7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }
}
