package 数学;

import org.junit.Test;

/**
 * @description: 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 输入:
 * 26
 * 输出:
 * "1a"
 * @return:
 * @Author: M
 * @create: 2022/7/17 19:40
 */

public class Test5 {
    public String toHex(int num) {
        if (num == 0) return "0";
        String hex = "0123456789abcdef";
        StringBuffer res = new StringBuffer();
        while (num != 0) {
            res.append(hex.charAt(num & 15));
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(toHex(-1));
    }
}
