package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.Arrays;

public class Test15 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int crossSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int threeNUms = nums[i] + nums[left] + nums[right];
                if (threeNUms > target) right--;
                else if (nums[i] < target) left++;
                else return target;
                if (Math.abs(crossSum - target) > Math.abs(threeNUms - target)) crossSum = threeNUms;
            }
        }
        return crossSum;
    }

    @Test
    public void test() {
        int[] nums = {-100, -98 ,- 2, -1};
        System.out.println(threeSumClosest(nums, 2));
    }
}
