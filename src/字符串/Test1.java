package 字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: s1 = AABCD, s2 = CDAA
 * Return : true
 * @return:
 * @Author: M
 * @create: 2022/7/19 15:14
 */

public class Test1 {
    public boolean isContain(String s1, String s2) {
        String longString = s1.length() > s2.length() ? s1 : s2;
        String shortString = s1.length() < s2.length() ? s1 : s2;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < longString.length(); i++) {
            String temp = longString.substring(1);
            longString = temp + longString.charAt(0);
            res.add(longString);
        }
        for (String s : res) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == shortString.charAt(count)) {
                    count++;
                } else {
                    continue;
                }
                if (count == shortString.length()) return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s1 = "AABCD", s2 = "BCDA";
        System.out.println(isContain(s1, s2));
    }
}
