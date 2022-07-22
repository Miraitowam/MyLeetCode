package 二分查找;

/**
 * @description: 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * @return:
 * @Author: M
 * @create: 2022/7/6 21:52
 */

public class Test3 {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
    }
}
