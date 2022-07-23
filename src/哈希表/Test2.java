package 哈希表;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @return:
 * @Author: M
 * @create: 2022/7/23 22:40
 */

public class Test2 {
    //使用set不能出现重复的原理
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) return true;
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
