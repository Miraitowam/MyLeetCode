package 滑动窗口;
/**
 * @description:
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * @return:  
 * @Author: M 
 * @create: 2022/8/25 15:09
 */
 
import org.junit.Test;

public class Test2 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        //定义左右指针
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    @Test
    public void test() {
        int target = 4;
        int[] nums = {1, 4, 4};
        System.out.println(minSubArrayLen(target, nums));
    }
}
