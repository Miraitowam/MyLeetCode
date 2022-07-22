package 字符串;

import org.junit.Test;

/**
 * @description: 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * @return:
 * @Author: M
 * @create: 2022/7/19 18:40
 */

public class Test7 {
    //定义切割数
    private int cut = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //针对子串长度为单数的情况
            extendedString(s, i, i);
            //子串长度为偶数
            extendedString(s, i, i + 1);
        }
        return cut;
    }

    //切割方法，中心扩散法
    public void extendedString(String s, int startPos, int endPos) {
        //遍历完往两边扩散如果扩散过去两边相等那么就说是一个子串
        while (startPos >= 0 && endPos < s.length() && s.charAt(startPos) == s.charAt(endPos)) {
            startPos--;
            endPos++;
            cut++;
        }
    }

    @Test
    public void test() {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
