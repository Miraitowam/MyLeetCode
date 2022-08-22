package LeetCode名企打卡.day5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * @return:
 * @Author: M
 * @create: 2022/8/20 21:03
 */

public class Test1 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }

    @Test
    public void test() {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}

