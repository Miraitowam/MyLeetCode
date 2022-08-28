package 华为机考;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * @return:
 * @Author: M
 * @create: 2022/8/25 19:46
 */

public class Test5 {
    public int findRadius(int[] houses, int[] heaters) {
        //给房屋和加热器全都排序
        Arrays.sort(heaters);
        Arrays.sort(houses);
        if (heaters[0] >= houses[houses.length - 1]) return heaters[0] - houses[0];
        //记录每个房屋想要取暖的最近距离
        int res = Integer.MIN_VALUE;
        int[] dp = new int[houses.length];
        for (int i = 0; i < dp.length; i++) {
            //左边的
            int left = 0;
            while (houses[i] > heaters[left] && left < heaters.length - 1) left++;
            //右边的
            int right = heaters.length - 1;
            while (houses[i] < heaters[right] && right > 0) right--;
            dp[i] = Math.min(Math.abs(houses[i] - heaters[left]), Math.abs(heaters[right] - houses[i]));
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] houses = {1, 2, 3,4};
        int[] heaters = {1,4};
        System.out.println(findRadius(houses, heaters));
    }

}
