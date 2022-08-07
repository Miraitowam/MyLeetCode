package 位运算;

import org.junit.Test;

/**
 * @description: 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * @return:
 * @Author: M
 * @create: 2022/8/2 15:03
 */

public class Test3 {
    public int missingNumber(int[] nums) {
        int cur = 0;
        for (int i = 1; i <= nums.length; i++) cur = cur ^ i ^ nums[i - 1];
        return cur;
    }

    @Test
    public void test() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
