package LeetCode名企打卡.day1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * @return:
 * @Author: M
 * @create: 2022/8/14 10:28
 */

public class Test5 {
    public int candy(int[] ratings) {
        //定义dp为每个孩子分到的糖果
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        //先从前往后遍历如果当前孩子的分比前一个人高那么糖果加一
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1]) dp[i] = dp[i - 1] + 1;
        //再从后往前遍历
        //再从后往前遍历如果当前孩子比后一个人分高那么就加一
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1]) dp[i] = Math.max(dp[i], dp[i + 1] + 1);
        //返回求和
        return Arrays.stream(dp).sum();
    }

    @Test
    public void test() {
        int[] ratings = {1, 3, 4, 5, 2};
        System.out.println(candy(ratings));
    }
}
