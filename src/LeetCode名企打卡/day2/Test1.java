package LeetCode名企打卡.day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * @return:
 * @Author: M
 * @create: 2022/8/14 10:48
 */

public class Test1 {
    private List<Integer> res = new ArrayList();

    public void sortColors(int[] nums) {
        addColor(nums, 0);
    }

    public void addColor(int[] nums, int k) {
        if (k == 3) {
            for (int i = 0; i < nums.length; i++)
                nums[i] = res.get(i);
            return;
        }
        for (int t : nums) if (t == k) res.add(t);
        addColor(nums, k + 1);
    }

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }
}
