package 栈和队列;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "()"
 * 输出：true
 * 输入：s = "()[]{}"
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/7/21 16:29
 */

public class Test4 {
    public boolean isValid(String s) {
        //如果长度不为偶数肯定不闭合
        if (s.length() % 2 != 0) return false;
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') temp.push(')');
            else if (c == '[') temp.push(']');
            else if (c == '{') temp.push('}');
            else if (temp.isEmpty() || c != temp.pop()) return false;
        }
        return temp.isEmpty();
    }

    @Test
    public void test() {
        String s = ")(";
        System.out.println(isValid(s));
    }
}
