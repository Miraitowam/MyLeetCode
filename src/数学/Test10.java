package 数学;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * @return:
 * @Author: M
 * @create: 2022/7/18 16:20
 */

public class Test10 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);      //先对数组排序
        int midNum = nums[nums.length / 2];     //找到中位数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == midNum) continue;
            count += Math.abs(nums[i] - midNum);
        }
        return count;
    }

    //
    @Test
    public void test() {
        int[] nums = {1, 10, 15};
        System.out.println(minMoves2(nums));
    }
}
