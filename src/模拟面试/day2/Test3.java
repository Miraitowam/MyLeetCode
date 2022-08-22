package 模拟面试.day2;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int len = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < len; i++) {
            num <<= 1;
            num |= nums[i];
            num %= 5;
            ans.add(num == 0);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0};
        System.out.println(prefixesDivBy5(nums));
    }
}
