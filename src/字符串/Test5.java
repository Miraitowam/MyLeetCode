package 字符串;

import org.junit.Test;

/**
 * @description: 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @return:
 * @Author: M
 * @create: 2022/7/19 16:06
 */

public class Test5 {
    public int longestPalindrome(String s) {
        //对应大小写字母
        int[] letters = new int[128];
        char[] arr = s.toCharArray();
        for (char c : arr) letters[c] += 1;   //标记对应字母出现的次数
        int res = 0;    //定义长度
        for (int i : letters) res += i % 2 == 0 ? i : i - 1;
        return res == s.length() ? res : res + 1;
    }
    @Test
    public void test(){
        String s = "AAAAAA";
        System.out.println(longestPalindrome(s));
    }
}
