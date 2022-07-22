package 数学;

import org.junit.Test;

/**
 * @description: 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * @return:
 * @Author: M
 * @create: 2022/7/17 19:52
 */

public class Test6 {
    public String convertToTitle(int columnNumber) {
        StringBuffer res = new StringBuffer();
        while (columnNumber != 0) {
            char temp = (char) ((columnNumber - 1) % 26 + 'A');
            res.append(temp);
            columnNumber = (columnNumber - 1) / 26;
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(2147483647));
    }
}
