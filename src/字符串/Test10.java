package 字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 给出一个单词数组words，其中每个单词都由小写英文字母组成。
 * 如果我们可以不改变其他字符的顺序，在 wordA的任何地方添加 恰好一个 字母使其变成wordB，那么我们认为wordA是wordB的 前身 。
 * 例如，"abc"是"abac"的 前身，而"cba"不是"bcad"的 前身
 * 词链是单词[word_1, word_2, ..., word_k]组成的序列，k >= 1，其中word1是word2的前身，word2是word3的前身，依此类推。
 * 一个单词通常是 k == 1 的 单词链。
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的最长可能长度 。
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * @return:
 * @Author: M
 * @create: 2022/8/26 20:58
 */

public class Test10 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });
        int[] dp = new int[words.length + 1];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (isSub(words[j - 1], words[i - 1])) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //判断是不是子序列
    public boolean isSub(String s1, String target) {
        if (target.length() - s1.length() != 1) return false;
        int sum = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == s1.charAt(sum)) sum++;
            if (sum == s1.length()) break;
        }
        return sum == s1.length();
    }

    @Test
    public void test() {
        String[] words = {"a", "b", "ab", "bac"};
        System.out.println(longestStrChain(words));
    }
}
