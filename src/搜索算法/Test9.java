package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @return:
 * @Author: M
 * @create: 2022/7/12 18:14
 */

public class Test9 {
    //定义一个list返回结果
    private List<String> res = new ArrayList<>();
    //定义一个映射表
    private String[] keyMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        //如果输入的为空或者长度为0那就返回空的
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer comBob = new StringBuffer();
        //使用递归得到结果
        findCombination(digits, 0, comBob);
        return res;
    }

    //找到所有可能的队列
    public void findCombination(String digits, int index, StringBuffer comBob) {
        //如果index到达digits的长度就返回,并把StringBuffer的所有内容添加到结果中
        if (comBob.length() == digits.length()) {
            res.add(comBob.toString());
            return;
        }
        //首先获得所有的keys
        char curNum = digits.charAt(index);
        String keys = keyMap[curNum - '0'];
        for (int i = 0; i < keys.length(); i++) {
            comBob.append(keys.charAt(i));
            findCombination(digits, index + 1, comBob);
            //清空StringBuffer
            comBob.deleteCharAt(comBob.length() - 1);
        }
        return;
    }

    @Test
    public void test() {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}

