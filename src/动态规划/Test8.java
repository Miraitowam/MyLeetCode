package 动态规划;

import org.junit.Test;

/**
 * @description: 给定一个整数数组 nums，处理以下类型的多个查询:
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，包含left和right两点
 * （也就是nums[left] + nums[left + 1] + ... + nums[right])
 * @return:
 * @Author: M
 * @create: 2022/8/4 12:41
 */

public class Test8 {
    private int[] sums;

    public Test8(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        Test8 test = new Test8(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(test.sumRange(0, 2));
    }
}
