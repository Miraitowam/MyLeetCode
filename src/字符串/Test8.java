package 字符串;

import org.junit.Test;

/**
 * @description: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 输入：x = 121
 * 输出：true
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @return:
 * @Author: M
 * @create: 2022/7/19 19:51
 */

public class Test8 {
    public boolean isPalindrome(int x) {
        //负数肯定不是
        if (x < 0) return false;
        String num = String.valueOf(x);
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) == num.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(10));
    }
}
