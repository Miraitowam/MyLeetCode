package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * @return:
 * @Author: M
 * @create: 2022/8/7 17:14
 */

public class Test22 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len;
        //dp_i表示长度为i的字符串能否被表示
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String curWord : wordDict) {
                if (i < curWord.length()) continue; //i小于当前单词长度根本不可能比较
                len = curWord.length();
                String str = s.substring(i - len, i);   //倒着比较当前长度的单词
                if (str.equals(curWord) && dp[i - len]) dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        //测试1
        String s = "applepenapple";
        String[] word = {"apple", "pen"};
        List<String> wordDict = Arrays.asList(word);
        //测试2
        String s1 = "catsandog";
        String[] word1 = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict1 = Arrays.asList(word1);
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak(s1, wordDict1));
    }
}
