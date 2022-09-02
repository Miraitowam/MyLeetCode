package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/5 14:53
 */

public class Test8 {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int index = -1;
        char[] s1 = s.toCharArray();
        for (char c : s1) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "absc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
