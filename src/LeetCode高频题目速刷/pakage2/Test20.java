package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * @return:
 * @Author: M
 * @create: 2022/9/14 17:07
 */

public class Test20 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] p_words = new int[26];
        int[] s_words = new int[26];
        //先统计p的数量
        for (char c : p.toCharArray()) p_words[c - 'a']++;
        int left = 0, right = 0;
        while (left <= s.length() - p.length()) {
            while (right - left < p.length()) s_words[s.charAt(right++) - 'a']++;
            int compare = Arrays.compare(p_words, s_words);
            if (compare == 0) ans.add(left);
            s_words[s.charAt(left++) - 'a']--;
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
