package 字符串;

import org.junit.Test;

/**
 * @description: 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * @return:
 * @Author: M
 * @create: 2022/7/19 19:58
 */

public class Test9 {
    private int cunt = 0;

    public int countBinarySubstrings(String s) {
        //开始遍历
        for (int i = 0; i < s.length(); i++) {
            extendedString(s, i, i + 1);
        }
        return cunt;
    }

    //扩展字符串
    public void extendedString(String s, int startPos, int endPos) {
        while (startPos >= 0 && endPos < s.length() && s.charAt(startPos) != s.charAt(endPos)) {
            if (endPos - startPos > 1) {
                if (s.charAt(startPos) != s.charAt(startPos + 1)) break;
            }
            startPos--;
            endPos++;
            cunt++;
        }
    }

    @Test
    public void test() {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
}
