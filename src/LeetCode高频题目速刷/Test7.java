package LeetCode高频题目速刷;

import org.junit.Test;

/**
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @return:
 * @Author: M
 * @create: 2022/9/2 16:43
 */

public class Test7 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (str.length() == 0) return "";
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    @Test
    public void test() {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
