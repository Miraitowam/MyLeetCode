package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 逆波兰表达式
 * @return:
 * @Author: M
 * @create: 2022/9/6 21:06
 */

public class Test25 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int nums1 = stack.pop();
                int nums2 = stack.pop();
                if (c.equals("+")) stack.push(nums1 + nums2);
                if (c.equals("-")) stack.push(nums2 - nums1);
                if (c.equals("*")) stack.push(nums1 * nums2);
                if (c.equals("/")) stack.push(nums2 / nums1);
            } else stack.push(Integer.valueOf(c));
        }
        return stack.pop();
    }

    @Test
    public void test() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}
