package LeetCode名企打卡.day5;

import java.util.Arrays;

/**
 * @description:
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * @return:
 * @Author: M
 * @create: 2022/8/21 16:39
 */

public class Test3 {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        //首先对数组进行排序
        Arrays.sort(nums);
        //开始尝试,只有两种可能
        int solution1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int solution2 = nums[len - 1] * nums[0] * nums[1];
        return Math.max(solution1, solution2);
    }
    //手写个快排序
    public void quickSort(int[] nums, int startPos, int endPos) {
        int leftIndex = startPos, rightIndex = endPos;   //参与循环的左右指针
        int pivot = nums[(startPos + endPos) / 2];      //基准值
        while (leftIndex < rightIndex) {   //循环到二者相等为止
            while (nums[leftIndex] < pivot) leftIndex++;  //在左边找到比pivot大的
            while (nums[rightIndex] > pivot) rightIndex--;  //在右边找到比pivot小的
            if (leftIndex >= rightIndex) break; //退出条件
            //没有退出就交换
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            //防止一直等于pivot死循环,让其中一个产生变化就好了
            if (nums[leftIndex] == pivot) rightIndex--;
        }
        //向左递归
        if (rightIndex > startPos) quickSort(nums, startPos, rightIndex - 1);
        //向右递归
        if (leftIndex < endPos) quickSort(nums, leftIndex + 1, endPos);
    }
}
