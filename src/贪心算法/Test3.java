package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足 xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * @return:
 * @Author: M
 * @create: 2022/7/5 10:33
 */

public class Test3 {
    public static int findMinArrowShots(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(intervals));
    }
}
