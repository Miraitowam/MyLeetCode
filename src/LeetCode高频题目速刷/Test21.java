package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 * @return:
 * @Author: M
 * @create: 2022/9/4 19:46
 */

public class Test21 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[][] date = new int[2 * n][2];
        int i = 0;
        for (int[] arr : intervals) {
            date[i++] = new int[]{arr[0], 1};  //上车
            date[i++] = new int[]{arr[1], -1};  //下车
        }
        Arrays.sort(date, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按照开始的时间排序
                int x = o1[0] - o2[0];
                return x == 0 ? o1[1] - o2[1] : x;
            }
        });
        int max = 0;
        int curCount = 0;
        for (int[] a : date) {
            curCount += a[1];
            max = Math.max(max, curCount);
        }
        return max;
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 5}, {8, 9}, {8, 9}};
        System.out.println(minMeetingRooms(intervals));
    }
}
