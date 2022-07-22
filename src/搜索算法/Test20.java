package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:27
 */

public class Test20 {
    //首先定义一个list返回所有可能的结果
    List<List<Integer>> res = new ArrayList<>();
    //定义一个中间结果变量
    List<Integer> tempRes = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //如果为空直接返回
        if (nums == null || nums.length == 0) {
            return res;
        }
        //首先对数组进行一次排序
        Arrays.sort(nums);
        //标志位是否被访问
        boolean[] isVisited = new boolean[nums.length];
        //由于要获得所有的排列，那就循环nums的长度次
        for (int i = 0; i <= nums.length; i++) {
            //每一次都用回溯法求解
            backTracing(nums, i, 0, isVisited);
        }
        return res;
    }

    //回溯法
    public void backTracing(int[] nums, int n, int start, boolean[] isVisited) {
        //定义推出的条件
        if (n == tempRes.size() || n == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //开始循环
        for (int i = start; i < nums.length; i++) {
            //判断是否重复
            if (i >= 1 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            int tempNum = nums[i];
            tempRes.add(tempNum);
            isVisited[i] = true;
            //向后递归
            backTracing(nums, n, i + 1, isVisited);
            //回溯
            tempRes.remove(tempRes.size() - 1);
            isVisited[i] = false;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1};
        System.out.println(subsetsWithDup(nums));
    }
}
