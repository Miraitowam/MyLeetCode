package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:26
 */

public class Test18 {
    //首先定义一个list返回所有的结果
    private List<List<Integer>> res = new ArrayList<>();
    //定义一个list记录中间可能的一个结果
    private List<Integer> tempRes = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        //回溯法求解
        backTracing(k, n, 1);
        //返回结果
        return res;
    }

    public void backTracing(int k, int n, int start) {
        //设置推出的条件：k=0或者n=0
        if (k == 0 || n == 0) {
            //如果同时满足
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(tempRes));
            }
            return;
        }
        //开始循环遍历每一个元素
        for (int i = start; i <= 9; i++) {
            //先取出一个元素进行分析
            int tempNum = i;
            //如果当前元素比n大那么就把这个元素添加到temp中,否则结束本次循环
            if (tempNum > n) break;
            tempRes.add(tempNum);
            //进行递归查找
            backTracing(k - 1, n - tempNum, i + 1);
            //回溯
            tempRes.remove(tempRes.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 15));
    }
}
