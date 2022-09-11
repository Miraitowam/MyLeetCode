package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 实现字符串的乘法
 * @return:
 * @Author: M
 * @create: 2022/9/6 22:09
 */

public class Test27 {
    public String multiply(String n1, String n2) {
        int n = n1.length(), m = n2.length();
        int[] res = new int[m + n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = n1.charAt(i) - '0';
                int b = n2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];    //移位相加
                res[i + j + 1] = r % 10;
                res[i + j] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
