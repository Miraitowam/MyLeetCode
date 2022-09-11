package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public List<Integer> countSmaller(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i : dp) res.add(i);
        return res;
    }

    @Test
    public void test() {
        int[] nums = {2,0,1};
        System.out.println(countSmaller(nums));
    }
}
