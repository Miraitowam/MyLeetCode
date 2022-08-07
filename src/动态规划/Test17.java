package 动态规划;

import org.junit.Test;

/**
 * @description: 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * @return:
 * @Author: M
 * @create: 2022/8/6 11:28
 */

public class Test17 {
    public boolean canPartition(int[] nums) {
        //先计算nums的和
        int sum = 0;
        for (int num : nums) sum += num;
        //如果sum是奇数那么肯定无法分割
        if (sum % 2 != 0) return false;
        //dp_ij表示前i个数在不超过num/2的情况下能够得到的最大值
        int[][] dp = new int[sum / 2 + 1][nums.length+1];
        //先遍历的是容量，再遍历的是物品
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= nums.length; j++) {
                //比较的是不添加此数和添加此数的最大值
                if (nums[j - 1] <= i) dp[i][j] = Math.max(dp[i][j - 1], dp[i - nums[j - 1]][j - 1] + nums[j - 1]);
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[sum / 2][nums.length - 1] == sum / 2;
    }


    @Test
    public void test() {
        int[] nums = {1, 5, 11, 5}; //true
        int[] nums1 = {1, 2, 3, 5}; //false
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7}; //true
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums1));
        System.out.println(canPartition(nums2));
    }
}
