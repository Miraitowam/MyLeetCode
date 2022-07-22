package 数学;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 输入：nums = [1,2,3]
 * 输出：6
 * @return:
 * @Author: M
 * @create: 2022/7/18 20:12
 */

public class Test15 {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        //首先对数组进行排序
        quickSort(nums, 0, len - 1);
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

    boolean is(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            } else {
                System.out.println(nums[i]);
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
//        int nums[] = {-1, 61, 53, -6, 12, 29, 35, 24, 976, 68, 797, 486};
        int nums[] = {722, 634, -504, -379, 163, -613, -842, -578, 750, 951, -158, 30, -238, -392, -487, -797, -157, -374, 999, -5, -521, -879, -858, 382, 626, 803, -347, 903, -205, 57, -342, 186, -736, 17, 83, 726, -960, 343, -984, 937, -758, -122, 577, -595, -544, -559, 903, -183, 192, 825, 368, -674, 57, -959, 884, 29, -681, -339, 582, 969, -95, -455, -275, 205, -548, 79, 258, 35, 233, 203, 20, -936, 878, -868, -458, -882, 867, -664, -892, -687, 322, 844, -745, 447, -909, -586, 69, -88, 88, 445, -553, -666, 130, -640, -918, -7, -420, -368, 250, -786};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(maximumProduct(nums));
    }
}
