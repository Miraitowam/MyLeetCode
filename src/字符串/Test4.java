package 字符串;

import org.junit.Test;


/**
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @return:
 * @Author: M
 * @create: 2022/7/19 15:47
 */

public class Test4 {
    public boolean isAnagram(String s, String t) {
        //判断长度是否相等不相等直接返回
        if (s.length() != t.length()) return false;
        //用数组实现标记
        char[] words = new char[26];
        for (int i = 0; i < s.length(); i++) words[s.charAt(i) - 'a'] += 1;
        for (int i = 0; i < t.length(); i++) words[t.charAt(i) - 'a'] -= 1;
        for (int i = 0; i < 26; i++) {
            if (words[i] != 0) return false;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
