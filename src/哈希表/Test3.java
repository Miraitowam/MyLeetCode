package 哈希表;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * @return:
 * @Author: M
 * @create: 2022/7/23 22:47
 */

public class Test3 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        //用map统计相同元素出现的次数
        for (int num : nums) {
            //如果map中没有就赋值为1否则就加1
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : nums) {
            if (countForNum.containsKey(num + 1))
                count = Math.max(count, countForNum.get(num) + countForNum.get(num + 1));
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        System.out.println(findLHS(nums));
    }
}
