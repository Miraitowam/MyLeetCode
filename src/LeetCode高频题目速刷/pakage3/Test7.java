package LeetCode高频题目速刷.pakage3;

import java.util.HashMap;

/**
 * @description: 罗马数字转整数
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * @return:
 * @Author: M
 * @create: 2022/11/22 15:41
 */

public class Test7 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                if (c == 'I' && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i += 1;
                } else if (c == 'I' && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i += 1;
                } else if (c == 'X' && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i += 1;
                } else if (c == 'X' && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i += 1;
                } else if (c == 'C' && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i += 1;
                } else if (c == 'C' && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i += 1;
                } else res += map.get(c);
            } else res += map.get(c);
        }
        return res;
    }
}
