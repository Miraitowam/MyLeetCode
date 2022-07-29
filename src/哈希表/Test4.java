package 哈希表;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @return:
 * @Author: M
 * @create: 2022/7/23 23:16
 */

public class Test4 {
    private Set<Integer> set = new HashSet();

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        for (int num : nums) set.add(num);    //将元素全部添加
        int count = 0;  //统计最长序列数
        for (int num : set) {
            //只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3
            if (!set.contains(num - 1)) count = Math.max(count, dfs(num));
        }
        return count;
    }

    //dfs遍历各种可能
    public int dfs(int i) {
        int count = 0;
        if (set.contains(i)) {
            count++;
        } else {
            return count;
        }
        count = count + dfs(i + 1); //  继续搜索
        return count;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, -1};
        System.out.println(longestConsecutive(nums));
    }
}
