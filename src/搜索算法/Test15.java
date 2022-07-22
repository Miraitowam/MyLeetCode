package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:24
 */

public class Test15 {
    public List<List<Integer>> combine(int n, int k) {
        //首先定义一个list返回所有的结果
        List<List<Integer>> res = new ArrayList<>();
        //定义一个list记录中间可能的一个结果
        List<Integer> tempRes = new ArrayList<>();
        //回溯法求解
        backTracing(res, tempRes, n, k, 1);
        //返回结果
        return res;
    }

    //回溯法求解
    public void backTracing(List<List<Integer>> res, List<Integer> tempRes, int n, int k, int index) {
        //定义退出条件:1.k==0
        if (k == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        //开始遍历每一个数
        for (int i = index; i <= n - k + 1; i++) {
            //如果没有被访问那么就取数字
            int tempNum = i;
            //把这个数添加到中间变量中
            tempRes.add(tempNum);
            //向右继续递归,由于不能存在重复，那么开始的index就应该从i后
            backTracing(res, tempRes, n, k - 1, i + 1);
            //删除掉因为递归而增加的变量
            tempRes.remove(tempRes.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 1));
    }
}
