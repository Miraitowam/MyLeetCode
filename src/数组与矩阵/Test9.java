package 数组与矩阵;

import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个非空且只包含非负数的整数数组nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * @return:
 * @Author: M
 * @create: 2022/7/31 22:48
 */

public class Test9 {
    public int findShortestSubArray(int[] nums) {
        //首先是获取数组的度，用map
        Map<Integer, Integer> map = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int maxValue = -1, res = nums.length;
        for (int value : map.values()) maxValue = Math.max(maxValue, value);    //找到最大的度
        for (int key : map.keySet()) {
            if (map.get(key) == maxValue) {
                res = Math.min(res, getLength(nums, key, map.get(key)));    //如果有多个key有相同的度那么取最短
            }
        }
        return res;
    }

    //返回对应key子列的长度
    public int getLength(int[] nums, int key, int value) {
        int start = 0, end = nums.length;
        int count = 0;
        for (int i = 0; i < nums.length && count < value; i++) {
            if (nums[i] == key) {
                if (count == 0) start = i;
                if (++count == value) end = i;
            }
        }
        //返回的是长度所以要加1
        return end - start + 1;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
}
