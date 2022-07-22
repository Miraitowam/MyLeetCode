package 数学;

import org.junit.Test;

/**
 * @description: 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * @return:
 * @Author: M
 * @create: 2022/7/18 15:32
 */

public class Test8 {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();  //用于记录结果
        int lastA = a.length() - 1;   //用于标记a的位置
        int lastB = b.length() - 1;   //用于标记b的位置
        int carry = 0;  //表示进位
        while (lastA >= 0 || lastB >= 0 || carry > 0) {   //只要存在任意一方没有计算完毕就继续循环
            //短的就用0来补充
            int num1 = lastA < 0 ? 0 : a.charAt(lastA--) - '0';
            int num2 = lastB < 0 ? 0 : b.charAt(lastB--) - '0';
            res.append((num1 + num2 + carry) % 2);  //追加结果
            carry = (num1 + num2 + carry) >= 2 ? 1 : 0;  //获得进位
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        String a = "11";
        String b = "11";
        System.out.println(addBinary(a, b));
    }
}
