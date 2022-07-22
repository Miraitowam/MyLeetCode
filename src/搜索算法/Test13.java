package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:22
 */

public class Test13 {
    public List<List<Integer>> permute(int[] nums) {
        //首先定义一个list返回所有的结果
        List<List<Integer>> res = new ArrayList<>();
        //定义一个list记录中间可能的一个结果
        List<Integer> tempRes = new ArrayList<>();
        //定义一个变量表示该节点是否被访问
        boolean[] isVisited = new boolean[nums.length];
        //回溯法求解
        backTracing(res, tempRes, nums, isVisited, 0);
        //返回结果
        return res;
    }
    //回溯法求解
    private void backTracing(List<List<Integer>> res, List<Integer> tempRes, int[] nums, boolean[] isVisited, int index) {
        //定义返回的条件：1.index达到nums的长度
        if (index == nums.length) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //先判断该数是否被访问过
            if (!isVisited[i]) {
                //将该数设置为已访问
                isVisited[i] = true;
                //先取出来一个数
                int tempNum = nums[i];
                //把这个数加入到tempRes中
                tempRes.add(tempNum);
                //向后递归
                backTracing(res, tempRes, nums, isVisited, index + 1);
                //删除掉因为递归而增加的部分
                tempRes.remove(tempRes.size() - 1);
                //设置为未访问
                isVisited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1,1,2};
        System.out.println(permute(nums));
    }
}
