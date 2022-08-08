package 动态规划;

import org.junit.Test;

/**
 * @description: 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * @return:
 * @Author: M
 * @create: 2022/8/7 20:38
 */

public class Test30 {
    public int minSteps(int n) {
        //dp表示操作次数
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            //如果i是偶数那么一定等于dp[i/2]+2;
            if (i % 2 == 0) dp[i] = dp[i / 2] + 2;
                //否则就为最大能够整除的数+商
            else {
                int maxNum = getMax(i);
                dp[i] = dp[maxNum] + i / maxNum;
            }
        }
        return dp[n];
    }

    //获得最大能够整除的数
    public int getMax(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) return i;
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(minSteps(57));
    }
}
