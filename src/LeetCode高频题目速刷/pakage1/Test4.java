package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeNum = merge(nums1, nums2);
        Double res;
        int len = mergeNum.length;
        if (len % 2 == 0) {
            Double t1 = Double.valueOf(mergeNum[len / 2 - 1]);
            Double t2 = Double.valueOf(mergeNum[len / 2]);
            res = (t1 + t2) / 2;
        } else res = Double.valueOf(mergeNum[len / 2]);
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] res = new int[len];
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (right == nums2.length) {
                res[i] = nums1[left++];
                continue;
            }
            if (left == nums1.length) {
                res[i] = nums2[right++];
                continue;
            }
            if (nums1[left] > nums2[right]) {
                res[i] = nums2[right];
                right++;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
