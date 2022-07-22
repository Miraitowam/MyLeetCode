package 字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 输入：s = "egg", t = "add"
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/19 16:28
 */

public class Test6 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        //ASCLL对照表
        char[] letters1 = new char[128];
        char[] letters2 = new char[128];
        //记录次数
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            //如果没有对照关系那就形成对照关系
            if (letters1[sc] != '\0' && letters1[sc] != tc) return false;
            if (letters2[tc] != '\0' && letters2[tc] != sc) return false;
            letters1[sc] = tc;
            letters2[tc] = sc;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "bbbaaaba", t = "aaabbbba";
        System.out.println(isIsomorphic(s, t));
    }
}
