package 华为机考;

import org.junit.Test;

/**
 * @description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @return:
 * @Author: M
 * @create: 2022/8/27 22:44
 */

public class Test15 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if (nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(canJump(nums));
    }
}
