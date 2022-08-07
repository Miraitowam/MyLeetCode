package 动态规划;

import org.junit.Test;

/**
 * @description: 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为(1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * @return:
 * @Author: M
 * @create: 2022/8/4 15:18
 */

public class Test12 {
    public int numDecodings(String s) {
        //只要首位是0通通返回0
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        //dp_i表示i时可以解码的总数
        int[] dp = new int[s.length()];
        dp[0] = 1;
        String cur = s.substring(0, 2);
        if (Integer.parseInt(cur) > 26 || s.contains("0")) {
            if (s.charAt(0) - '2' > 0 && s.charAt(1) == '0') dp[1] = 0;
            else dp[1] = 1;
        } else dp[1] = 2;
        for (int i = 2; i < s.length(); i++) {
            //判断当前元素与前面一个元素的组合是否超过26
            String curString = s.substring(i - 1, i + 1);
            //出现了类似于30,40,50,60都会导致最终结果为0
            if (Integer.parseInt(curString) > 26 && Integer.parseInt(curString) % 10 == 0) return 0;
            if (Integer.parseInt(curString) == 0) return 0; //中间出现两个0是绝对无效的
            if ((Integer.parseInt(curString) > 26 && s.charAt(i + 1) != '0') || Integer.parseInt(curString) < 10 ||
                    Integer.parseInt(curString) % 10 == 0) {
                dp[i] = dp[i - 1];
            }    //说明加入当前元素后不合法，没有起到作用
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[s.length() - 1];
    }

    @Test
    public void test() {
        String s = "1201234";
        System.out.println(numDecodings(s));
    }
}
