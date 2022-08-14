package LeetCode名企打卡.day1;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @return:
 * @Author: M
 * @create: 2022/8/13 22:45
 */

public class Test3 {
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
        System.out.println(twoSum(nums, 9));
    }
}
