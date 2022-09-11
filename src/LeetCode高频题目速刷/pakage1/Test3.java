package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @return:
 * @Author: M
 * @create: 2022/9/1 17:46
 */

public class Test3 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[0] = -1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] >= i - j) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length];
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
