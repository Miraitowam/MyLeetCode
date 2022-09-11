package LeetCode高频题目速刷.pakage2;


import org.junit.Test;

public class Test9 {
    public boolean isMatch(String s, String p) {
        //dp_ij表示p的前i个字符和s的前j个字符是否能匹配
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 2; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') dp[i][0] = dp[i - 2][0];
        }
        for (int i = 1; i <= p.length(); i++) {
            char p_i = p.charAt(i - 1);
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(j - 1) == p_i) dp[i][j] = dp[i - 1][j - 1];
                else if (p_i == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (p_i == '*') {
                    if (s.charAt(j - 1) != p.charAt(i - 2) && p.charAt(i - 2) != '.') dp[i][j] = dp[i - 2][j];
                    else dp[i][j] = dp[i - 2][j] || dp[i][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    @Test
    public void test() {
        String s = "aa", p = "a*";
        System.out.println(isMatch(s, p));
    }
}
