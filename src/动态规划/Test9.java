package 动态规划;

import org.junit.Test;

/**
 * @description: 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 * @return:
 * @Author: M
 * @create: 2022/8/4 12:59
 */

public class Test9 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        //dp_i表示当前等差数组的个数
        int[] dp = new int[nums.length];
        //初始化
        dp[0] = 0;
        dp[1] = 0;
        //等差数列的等差
        int count = 1;
        //发现规律，等差数组的个数也是一个等差数列！！！
        //是否是等差数列
        for (int i = 2; i < nums.length; i++) {
            //是等差数列
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + count;
                count++;
            } else {    //说明不再是等差数列，得把等差重置
                dp[i] = dp[i - 1];
                count = 1;
            }
        }
        return dp[nums.length - 1];
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 6, 8,8,8};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
