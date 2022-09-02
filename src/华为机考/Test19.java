package 华为机考;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @return:
 * @Author: M
 * @create: 2022/8/28 20:18
 */

public class Test19 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 3) {
            int result = 0;
            for (int i : nums) result += i;
            if (result == 0) {
                List<Integer> r = new ArrayList<>();
                for (int i : nums) r.add(i);
                res.add(r);
                return res;
            }
            return res;
        }
        Arrays.sort(nums);
        isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, 0, new ArrayList<>());
        }
        return res;
    }

    public void dfs(int[] nums, int start, int count, List<Integer> ans) {
        if (start < 0 || start > nums.length) return;
        if (count == 3) {
            int result = 0;
            for (int i = 0; i < 3; i++) result += ans.get(i);
            if (result == 0) if (!res.contains(ans)) res.add(new ArrayList<>(ans));
            return;
        }
        if (start == nums.length) return;
        if (isVisited[start]) return;
        isVisited[start] = true;
        ans.add(nums[start]);
        for (int i = start; i < nums.length; i++) {
            dfs(nums, i + 1, count + 1, ans);
        }
        isVisited[start] = false;
        ans.remove(ans.size() - 1);
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2,-1,-4};
        System.out.println(threeSum(nums));

    }
}
