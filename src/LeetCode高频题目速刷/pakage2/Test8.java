package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * @return:
 * @Author: M
 * @create: 2022/9/11 16:06
 */

public class Test8 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1, nums1.length - n);
        int left = 0, right = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (left == m) nums1[i] = nums2[right++];
            else if (right == n) nums1[i] = temp[left++];
            else if (temp[left] < nums2[right]) nums1[i] = temp[left++];
            else nums1[i] = nums2[right++];
        }
    }

    @Test
    public void test() {
        int[] nums1 = {4, 5, 6, 0, 0, 0}, nums2 = {1, 2, 3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
