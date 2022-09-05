package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * @return:
 * @Author: M
 * @create: 2022/9/2 22:04
 */

public class Test11 {
    private int[] temp;
    private int[] tempIndex;
    private int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (len == 1) {
            res.add(0);
            return res;
        }
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) temp[i] = i;
        mergeSort(nums, 0, nums.length - 1);
        for (int t : ans) res.add(t);
        return res;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        int leftStart = start, rightStart = mid + 1;
        mergeSort(nums, start, mid);  //归并左边
        mergeSort(nums, mid + 1, end);  //归并右边
        if (nums.length == 2 && nums[temp[leftStart]] <= nums[temp[rightStart]]) return;
        for (int i = start; i <= end; i++) {
            if (leftStart == mid + 1) tempIndex[i] = temp[rightStart++];
            else if (rightStart == end + 1) {
                ans[temp[leftStart]] += rightStart - mid - 1;
                tempIndex[i] = temp[leftStart++];
            } else if (nums[temp[leftStart]] < nums[temp[rightStart]]) {
                ans[temp[leftStart]] += rightStart - mid - 1;
                tempIndex[i] = temp[leftStart++];
            } else tempIndex[i] = temp[rightStart++];
        }
        for (int i = start; i <= end; i++) temp[i] = tempIndex[i];
    }

    @Test
    public void test() {
        int[] nums = {-1, -1};
        System.out.println(countSmaller(nums));
    }
}
