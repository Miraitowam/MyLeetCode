package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * @return:
 * @Author: M
 * @create: 2022/9/4 19:45
 */

public class Test20 {
    public int minEatingSpeed(int[] piles, int h) {
        int leftIndex = 1, rightIndex = Arrays.stream(piles).max().getAsInt();
        int mid = 1;
        while (rightIndex >= leftIndex) {
            mid = leftIndex + (rightIndex - leftIndex) / 2;
            long hour = getHours(piles, mid);
            if (hour <= h) {
                rightIndex = mid - 1;
            } else if (hour > h) {
                leftIndex = mid + 1;
            }
        }
        return leftIndex;
    }

    long getHours(int[] piles, int k) {
        long result = 0;
        for (int i = 0; i < piles.length; i++) {
            if (k >= piles[i]) result++;
            else {
                result += piles[i] / k;
                if (piles[i] % k != 0) result++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 6));
    }
}
