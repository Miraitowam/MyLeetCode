package 贪心算法;

/**
 * @description: 给你一个长度为n的整数数组nums，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * @return:
 * @Author: M
 * @create: 2022/7/5 14:54
 */

public class Test9 {
    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        if (cnt <= 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 1, 2};
        System.out.println(checkPossibility(nums));
    }
}
