package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * @return:
 * @Author: M
 * @create: 2022/9/14 21:25
 */

public class Test21 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> tempRes, int index) {
        if (index == nums.length || tempRes.size() >= 2) {
            if (tempRes.size() >= 2 && index <= nums.length) res.add(new ArrayList<>(tempRes));
            if (index == nums.length) return;
        }
        int[] used = new int[201];
        for (int i = index; i < nums.length; i++) {
            if (!tempRes.isEmpty() && nums[i] < tempRes.get(tempRes.size() - 1) || (used[nums[i] + 100] == 1)) continue;
            tempRes.add(nums[i]);
            used[nums[i] + 100] = 1;
            dfs(nums, tempRes, i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findSubsequences(nums));
    }
}
