package 双指针;

/**
 * @description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted
 * array.
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * @return:
 * @Author: M
 * @create: 2022/6/29 22:37
 */

public class Test5 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int mergeNum = m + n - 1;
        for (int k = 0; k < mergeNum; k++) {
            if (nums1[i] > nums2[j]) {
                nums1[mergeNum--] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[mergeNum--] = nums2[j--];
            } else {
                nums1[mergeNum--] = nums2[i--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
