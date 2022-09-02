package 华为机考;

import org.junit.Test;

public class Test21 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        shuffle(nums, 3);
    }
}
