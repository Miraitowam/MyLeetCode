package 动态规划;

import org.junit.Test;

/**
 * @description: 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:37
 */
public class Test28 {
    public int minDistance(String word1, String word2) {
        //定义dp_ij表示为word1中的前i个字符变换到word2中的前j个字符，最短操作次数
        //增加：dp[i][j - 1]
        //删除：dp[i - 1][j]
        //修改：dp[i - 1][j - 1]
        //首先初始化
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;   //字符串1变为空字符串只能删除所以次数为i
        for (int i = 0; i <= len2; i++) dp[0][i] = i;   //字符串2变为空字符串只能删除所以次数为i
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];    //当前字符相同说明不用变化那就和上个状态一样
                    // 否则就是增删改的最小值+1
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[len1][len2];
    }

    @Test
    public void test() {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
