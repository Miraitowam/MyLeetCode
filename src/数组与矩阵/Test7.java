package 数组与矩阵;

import org.junit.Test;

/**
 * @description: 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 输出：[2,3]
 * @return:
 * @Author: M
 * @create: 2022/7/30 22:35
 */

public class Test7 {
    public int findDuplicate(int[] nums) {
//        boolean[] has = new boolean[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            has[nums[i]] = !has[nums[i]];   //翻转标记
//            if (!has[nums[i]]) return nums[i];  //反转之后还是false说明这个数翻转了两次那肯定重了
//        }
//        return 0;
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println(slow + ":" + fast);
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            System.out.println(slow + ":" + fast);
        }
        return slow;
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }
}
