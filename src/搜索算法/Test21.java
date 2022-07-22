package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * @return:
 * @Author: M
 * @create: 2022/7/13 15:28
 */

public class Test21 {
    //首先定义一个list返回所有可能的结果
    List<List<String>> res = new ArrayList<>();
    //定义一个中间结果变量
    List<String> tempRes = new ArrayList<>();

    public List<List<String>> partition(String s) {
        //如果为空直接返回
        if (s == null || s.length() == 0) {
            return res;
        }
        //返回任意长度的回文串,长度从一开始
        backTracing(s);
        return res;
    }

    //回溯法切割字符串
    public void backTracing(String s) {
        //定义推出的条件,被切割完毕
        if (s.length() == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String tempString = s.substring(0, i);
            //如果是回文串，那就继续切割下去
            if (isPalindrome(tempString)) {
                tempRes.add(tempString);
                backTracing(s.substring(i));
                tempRes.remove(tempRes.size() - 1);
            }
        }
    }

    //首先写一个工具判断是否是回文串
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aaa";
        System.out.println(partition(s));
    }
}
