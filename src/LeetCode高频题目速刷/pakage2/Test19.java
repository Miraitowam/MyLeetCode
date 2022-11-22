package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * @return:
 * @Author: M
 * @create: 2022/9/14 16:49
 */

public class Test19 {
    public String minWindow(String s, String t) {
        //统计字母出现的次数
        HashMap<Character, Integer> s_words = new HashMap<>();
        HashMap<Character, Integer> t_words = new HashMap<>();
        for (int i = 0; i < t.length(); i++) t_words.put(t.charAt(i), t_words.getOrDefault(t.charAt(i), 0) + 1);
        String ans = "";
        int len = Integer.MAX_VALUE, count = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            s_words.put(s.charAt(i), s_words.getOrDefault(s.charAt(i), 0) + 1);
            if (t_words.containsKey(s.charAt(i)) && s_words.get(s.charAt(i)) <= t_words.get(s.charAt(i))) count++;
            while (j < i && (!t_words.containsKey(s.charAt(j)) || s_words.get(s.charAt(j)) > t_words.get(s.charAt(j)))) {
                int cnt = s_words.get(s.charAt(j)) - 1;
                s_words.put(s.charAt(j), cnt);
                j++;
            }
            if (count == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
