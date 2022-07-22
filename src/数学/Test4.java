package 数学;

import org.junit.Test;

/**
 * @description: 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 输入: num = 100
 * 输出: "202"
 * @return:
 * @Author: M
 * @create: 2022/7/17 19:23
 */

public class Test4 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean isNegative = num < 0;
        StringBuffer res = new StringBuffer();
        if (isNegative) num = -num;
        while (num > 0) {
            res.append(num % 7);
            num = num / 7;
        }
        return isNegative ? "-" + res.reverse().toString() : res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToBase7(-7));
    }
}
