package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:24
 */

public class Test16 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //首先定义一个list返回所有的结果
        List<List<Integer>> res = new ArrayList<>();
        //定义一个list记录中间可能的一个结果
        List<Integer> tempRes = new ArrayList<>();
        //首先对数组进行排序
        Arrays.sort(candidates);
        //回溯法求解
        backTracing(res, tempRes, candidates, target, 0);
        //返回结果
        return res;
    }

    //回溯算法
    public void backTracing(List<List<Integer>> res, List<Integer> tempRes, int[] candidates, int target, int start) {
        //定义退出的条件:1.target = 0,不需要补充元素
        if (target == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //开始循环遍历每一个元素
        for (int i = start; i < candidates.length; i++) {
            //先取出一个元素进行分析
            int tempNum = candidates[i];
            //如果这个元素是小于等于target那么就直接添加否则就直接退出
            if (tempNum > target) break;
            tempRes.add(tempNum);
            //如果添加了就继续递归求解
            backTracing(res, tempRes, candidates, target - tempNum, i);
            //回溯
            tempRes.remove(tempRes.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 8));
    }
}
