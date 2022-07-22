package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:25
 */

public class Test17 {
    //首先定义一个list返回所有的结果
    private List<List<Integer>> res = new ArrayList<>();
    //定义一个list记录中间可能的一个结果
    private List<Integer> tempRes = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //首先对数组进行排序
        Arrays.sort(candidates);
        //标记是否被访问
        boolean[] isVisited = new boolean[candidates.length];
        //回溯法求解
        backTracing(candidates, target, isVisited, 0);
        //返回结果
        return res;
    }

    private void backTracing(int[] candidates, int target, boolean[] isVisited, int start) {
        //定义退出的条件:1.target = 0,不需要补充元素
        if (target == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //开始循环遍历每一个元素
        for (int i = start; i < candidates.length; i++) {
            //如果元素相同且前面元素未访问，直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !isVisited[i-1]) {
                continue;
            }
            //先判断当前节点是否被访问
            if (!isVisited[i]) {
                //把当前元素标记为已访问
                isVisited[i] = true;
                //先取出一个元素进行分析
                int tempNum = candidates[i];
                //如果这个元素是小于等于target那么就直接添加否则就直接退出
                if (tempNum > target) {
                    isVisited[i] = false;
                    break;
                }
                tempRes.add(tempNum);
                //如果添加了就继续递归求解
                backTracing(candidates, target - tempNum, isVisited, i);
                //回溯
                tempRes.remove(tempRes.size() - 1);
                isVisited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}
