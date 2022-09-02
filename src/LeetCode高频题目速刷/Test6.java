package LeetCode高频题目速刷;

import org.junit.Test;

/**
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * @return:
 * @Author: M
 * @create: 2022/9/2 16:27
 */

public class Test6 {
    //动态规划解决
    public int trap(int[] height) {
        //左边柱子的最大值
        int[] leftMax = new int[height.length];
        //右边柱子的最大值
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        for (int i = height.length - 2; i >= 0; i--) rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        int res = 0;
        for (int i = 0; i < height.length; i++) res += Math.min(leftMax[i], rightMax[i]) - height[i];
        return res;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
