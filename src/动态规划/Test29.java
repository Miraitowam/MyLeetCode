package 动态规划;

import org.junit.Test;

/**
 * @description: 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:36
 */

public class Test29 {
    public int minDistance(String word1, String word2) {
        //定义dp_ij表示为word1中的前i个字符变换到word2中的前j个字符，最短操作次数
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化
        for (int i = 0; i <= len1; i++) dp[i][0] = i;   //字符串1变为空字符串只能删除所以次数为i
        for (int i = 0; i <= len2; i++) dp[0][i] = i;   //字符串2变为空字符串只能删除所以次数为i
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];    //如果相等那么就全保留
                    //否则就看是删除i还是j还是全部删除
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        return dp[len1][len2];
    }

    //最长字符串匹配
    public int longestCommonSubsequence(String text1, String text2) {
        //定义dp_ij表示为word1中的前i个字符与word2中的前j个字符的最长公共子序列
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }

    @Test
    public void test() {
        String word1 = "abcba", word2 = "abcbcba";
        System.out.println(minDistance(word1, word2));
        System.out.println(longestCommonSubsequence(word1, word2));
    }
}
