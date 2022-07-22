package 数学;

import org.junit.Test;

/**
 * @description: 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * @return:
 * @Author: M
 * @create: 2022/7/18 16:06
 */

public class Test9 {
    public String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();  //定义结果
        int lastNum1 = num1.length() - 1;     //定义字符串1的序号
        int lastNum2 = num2.length() - 1;     //定义字符串2的序号
        int carry = 0;  //定义进位
        while (lastNum1 >= 0 || lastNum2 >= 0 || carry > 0) {
            int add1 = lastNum1 < 0 ? 0 : num1.charAt(lastNum1--) - '0';
            int add2 = lastNum2 < 0 ? 0 : num2.charAt(lastNum2--) - '0';
            res.append((add1 + add2 + carry) % 10);     //插入结果
            carry = (add1 + add2 + carry) / 10;
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addStrings("456", "123"));
    }
}
