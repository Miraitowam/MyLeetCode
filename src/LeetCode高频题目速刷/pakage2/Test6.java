package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

/**
 * @description: 给定一个包含小写英文字母的字符串s以及一个矩阵shift，其中shift[i] = [direction, amount]：
 * direction可以为0（表示左移）或1（表示右移）。
 * amount表示s左右移的位数。
 * 左移 1 位表示移除s的第一个字符，并将该字符插入到 s 的结尾。
 * 类似地，右移 1 位表示移除s的最后一个字符，并将该字符插入到 s 的开头。
 * 对这个字符串进行所有操作后，返回最终结果。
 * 输入：s = "abc", shift = [[0,1],[1,2]]
 * 输出："cab"
 * 解释：
 * [0,1] 表示左移 1 位。 "abc" -> "bca"
 * [1,2] 表示右移 2 位。 "bca" -> "cab"
 * @return:
 * @Author: M
 * @create: 2022/9/10 22:53
 */

public class Test6 {
    public String stringShift(String s, int[][] shift) {
        String curStr = s;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) curStr = rightShift(curStr, shift[i][1]);
            else curStr = leftShift(curStr, shift[i][1]);
        }
        return curStr;
    }

    public String leftShift(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer(s);
        for (int i = 0; i < n; i++) {
            char c = stringBuffer.charAt(stringBuffer.length() - 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer.insert(0, c);
        }
        return stringBuffer.toString();
    }

    public String rightShift(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer(s);
        for (int i = 0; i < n; i++) {
            char c = stringBuffer.charAt(0);
            stringBuffer.deleteCharAt(0);
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() {
        String s = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        System.out.println(stringShift(s, shift));
    }
}
