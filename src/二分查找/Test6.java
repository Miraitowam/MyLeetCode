package 二分查找;

/**
 * @description: 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @return:
 * @Author: M
 * @create: 2022/7/8 11:03
 */

public class Test6 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        if (nums[0] == nums[nums.length - 1]) {
            return new int[]{0, nums.length - 1};
        }
        int left = getLeft(nums, target);
        int right = getRight(nums, target);

        return new int[]{left, right};
    }

    private static int getLeft(int nums[], int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : left + 1;
    }

    private static int getRight(int nums[], int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] result = searchRange(nums, 3);
        for (int temp : result) {
            System.out.print(temp + " ");
        }
    }
}
