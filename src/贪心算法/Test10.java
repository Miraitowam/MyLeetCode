package 贪心算法;

/**
 * @description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * @return:
 * @Author: M
 * @create: 2022/7/5 14:54
 */

public class Test10 {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = 0;
        int temp = 0;
        for (int num : nums) {
            if (num < temp + num) {
                temp += num;
            } else {
                temp = num;
            }
            maxSum = Math.max(maxSum, temp);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
