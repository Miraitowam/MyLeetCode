package 数组与矩阵;
/**
 * @description: 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * @return:
 * @Author: M
 * @create: 2022/7/30 17:36
 */

import org.junit.Test;

public class Test3 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
