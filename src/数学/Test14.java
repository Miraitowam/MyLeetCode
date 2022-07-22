package 数学;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * @return:
 * @Author: M
 * @create: 2022/7/18 17:31
 */

public class Test14 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
