package 哈希表;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @return:
 * @Author: M
 * @create: 2022/7/23 22:22
 */

public class Test1 {
    //用哈希表实现，将元素以及下标放进去，如果取得到target-nums那就返回下标
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //进行取元素，如果存在直接返回
            if (indexForNum.containsKey(target - nums[i]))
                return new int[]{indexForNum.get(target - nums[i]), i};
            //如果没取到就继续添加元素
            indexForNum.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
