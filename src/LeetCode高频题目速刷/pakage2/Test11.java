package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @return:
 * @Author: M
 * @create: 2022/9/11 20:59
 */

public class Test11 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIn = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIn[i] = Arrays.copyOf(intervals[i], 2);
        }
        newIn[intervals.length] = newInterval;
        Arrays.sort(newIn, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int start = newIn[0][0];
        int end = newIn[0][1];
        for (int i = 1; i < newIn.length; i++) {
            if (newIn[i][0] <= end) {
                end = Math.max(end, newIn[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = newIn[i][0];
                end = newIn[i][1];
            }
        }
        res.add(new int[]{start, end});
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Arrays.copyOf(res.get(i), 2);
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        insert(intervals, newInterval);
    }
}
