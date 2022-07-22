package 字符串;

import org.junit.Test;

/**
 * @description: s = "abcd123" k = 3
 * Return "123abcd"
 * @return:
 * @Author: M
 * @create: 2022/7/19 15:35
 */

public class Test2 {
    public String reverse(String s, int k) {
        while (k > 0) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            k--;
        }
        return s;
    }

    @Test
    public void test() {
        String s = "abcd123";
        System.out.println(reverse(s, 3));
    }
}
