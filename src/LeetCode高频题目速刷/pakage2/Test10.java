package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * @return:
 * @Author: M
 * @create: 2022/9/11 20:00
 */

public class Test10 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int row = 1; //列数
        int mid = numRows - 2;  //中间部分的列数
        int len = s.length();
        while (len > numRows) {
            len -= numRows;
            row++;
            len -= mid;
            row += mid;
        }
        char[][] zStr = new char[numRows][row];
        for (int i = 0; i < zStr.length; i++) Arrays.fill(zStr[i], '*');
        int index = 0;
        int posX = 0, posY = 0;
        label:
        while (index < s.length()) {
            //向下
            for (int i = 0; i < numRows; i++) {
                zStr[posX++][posY] = s.charAt(index++);
                if (index == s.length()) break label;
            }
            //向上
            posX -= 2;
            posY++;
            for (int i = 0; i < mid; i++) {
                zStr[posX--][posY++] = s.charAt(index++);
                if (index == s.length()) break label;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < zStr.length; i++) {
            for (int j = 0; j < zStr[i].length; j++) {
                if (zStr[i][j] != '*') stringBuffer.append(zStr[i][j]);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
