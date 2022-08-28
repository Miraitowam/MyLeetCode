package 华为机考;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * @return:
 * @Author: M
 * @create: 2022/8/28 14:35
 */

public class Test17 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
        }
        //去除0
        if (s.charAt(0) == '0' && s.length() > 1) {
            int len = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0') len++;
                else break;
            }
            if (len == s.length()) return "0";
            s.delete(0, len);
        }
        return s.toString();
    }

    @Test
    public void test() {
        String num = "100";
        System.out.println(removeKdigits(num, 1));
    }
}
