package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:23
 */

public class Test14 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //首先定义一个list返回所有的结果
        List<List<Integer>> res = new ArrayList<>();
        //定义一个list记录中间可能的一个结果
        List<Integer> tempRes = new ArrayList<>();
        //定义一个变量表示该节点是否被访问
        boolean[] isVisited = new boolean[nums.length];
        //首先要对数组进行升序排列
        Arrays.sort(nums);
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
        //开始遍历每一个数求出所有可能的排列组合
        for (int i = 0; i < nums.length; i++) {
            //判断是否与前面的数存在重复，如果存在则跳过本次循环
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            //判断是否被访问过
            if (!isVisited[i]) {
                //先把这个数标记为已访问
                isVisited[i] = true;
                //如果没有被访问那就先取一个数出来
                int tempNum = nums[i];
                //把这个数加入到中间变量中
                tempRes.add(tempNum);
                //继续向后遍历
                backTracing(res, tempRes, nums, isVisited, index + 1);
                //删除掉因为向后遍历而增加的数
                tempRes.remove(tempRes.size() - 1);
                //将此节点标记为已访问
                isVisited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1};
        System.out.println(permuteUnique(nums));
    }
}
