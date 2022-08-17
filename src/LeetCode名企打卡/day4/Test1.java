package LeetCode名企打卡.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "()[]{}"
 * 输出：true
 * @return:
 * @Author: M
 * @create: 2022/8/17 11:41
 */

public class Test1 {
    Map<Character, Character> map = new HashMap<>();

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //先添加元素
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        //再遍历
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(map.get(c));
            } else {
                char cur = stack.pop();
                if (cur != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
