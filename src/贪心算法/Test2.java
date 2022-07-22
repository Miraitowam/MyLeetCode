package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Given a collection of intervals, find the minimum number of intervals you need to remove to
 * make the rest of the intervals non-overlapping.
 * Note:    不重叠的区间数
 * 1. You may assume the interval's end point is always bigger than its start point.
 * 2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non over lapping.
 * @return:
 * @Author: M
 * @create: 2022/7/5 9:57
 */

public class Test2 {
    public static int eraseOverLapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //我的写法
//        Map<Integer, Integer> inter = new HashMap(intervals.length);
//        for (int[] temp : intervals) {
//            int start = temp[0];
//            int end = temp[0];
//            inter.put(start, end);
//        }
//        return intervals.length - inter.size();
        //贪心算法
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverLapIntervals(intervals));
    }
}
