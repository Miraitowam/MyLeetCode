package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @return:
 * @Author: M
 * @create: 2022/9/1 17:15
 */

public class Test2 {
    public List<String> res = new ArrayList<>();
    String curStr = "";

    public List<String> generateParenthesis(int n) {
        dfs('(', n);
        return res;
    }

    public void dfs(char c, int n) {
        curStr = curStr + c;
        int count = 0;
        int count2 = 0;
        for (char cc : curStr.toCharArray())
            if (cc == '(') count++;
            else count2++;
        if (count2 > count) return;
        if (count > n || count2 > n) return;
        if (count == n && count2 == n) {
            res.add(curStr);
            return;
        }
        dfs('(', n);
        curStr = curStr.substring(0, curStr.length() - 1);
        dfs(')', n);
        curStr = curStr.substring(0, curStr.length() - 1);
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(1));
    }
}
