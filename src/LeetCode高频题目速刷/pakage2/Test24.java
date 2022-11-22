package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

/**
 * @description: 12. 整数转罗马数字
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
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
 * @create: 2022/9/15 14:12
 */

public class Test24 {
    public String intToRoman(int num) {
        String[][] table = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}};
        String th = "M";
        StringBuffer result = new StringBuffer();
        int count = 0;
        while (num != 0) {
            int cur = num % 10;
            if (count == 3) {
                for (int i = 0; i < cur; i++)
                    result.insert(0, th);
                break;
            }
            num /= 10;
            if (cur > 0) result.insert(0, table[count][cur - 1]);
            count++;
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(intToRoman(1001));
    }
}
