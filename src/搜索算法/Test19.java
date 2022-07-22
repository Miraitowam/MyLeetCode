package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:27
 */

public class Test19 {
    //首先定义一个list返回所有可能的结果
    List<List<Integer>> res = new ArrayList<>();
    //定义一个中间结果变量
    List<Integer> tempRes = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        //由于要获得所有的排列，那就循环nums的长度次
        for (int i = 0; i <= nums.length; i++) {
            //每一次都用回溯法求解
            backTracing(nums, i, 0);
        }
        return res;
    }

    public void backTracing(int[] nums, int n, int start) {
        //定义推出的条件
        if (n == tempRes.size() || n == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //开始循环
        for (int i = start; i < nums.length; i++) {
            int tempNum = nums[i];
            tempRes.add(tempNum);
            //向后递归
            backTracing(nums, n, i + 1);
            //回溯
            tempRes.remove(tempRes.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {};
        System.out.println(subsets(nums));
    }
}
