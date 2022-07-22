package 数学;

import org.junit.Test;

/**
 * @description: 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入：nums = [3,2,3]
 * 输出：3
 * @return:
 * @Author: M
 * @create: 2022/7/18 16:51
 */

public class Test11 {
    public int majorityElement(int[] nums) {
        //莫尔法求出现次数最多的元素
        int candidate = nums[0];    //候选人
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) count++;
            else count--;
            if (count == 0) candidate = nums[i + 1];
        }
        return candidate;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
