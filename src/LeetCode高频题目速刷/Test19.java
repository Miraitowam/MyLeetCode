package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 一位老师正在出一场由 n道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F'表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是最大化有 连续相同结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串answerKey，其中answerKey[i]是第 i个问题的正确结果。除此以外，还给你一个整数 k，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为'T' 或者'F'（也就是将 answerKey[i] 改为'T'或者'F'）。
 * 请你返回在不超过 k次操作的情况下，最大连续 'T'或者 'F'的数目。
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 * @return
 * @Author: M
 * @create: 2022/9/4 19:44
 */

public class Test19 {
    List<List<Integer>> result = new ArrayList<>();

    //四数之和，没剪枝，超时
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            dfs(nums, target, i, new ArrayList<>());
        }
        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 4) {
            if (nums.length == 4) {
                long sum = 0;
                for (int k : nums) sum += k;
                if (sum == target) res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public void dfs(int[] nums, int target, int x, List<Integer> list) {
        if (x == nums.length || list.size() == 4) {
            if (list.size() == 4) {
                int sum = 0;
                for (int i : list) sum += i;
                if (sum == target) if (!result.contains(list))
                    result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[x]);
        for (int i = x; i < nums.length; i++) {
            dfs(nums, target, i + 1, list);
        }
        list.remove(list.size() - 1);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int slow = 0; //快慢指针
        int T = 0, F = 0;
        int ans = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char c = answerKey.charAt(i);
            if (c == 'T') T++;
            else F++;
            while (T > k && F > k) {
                if (answerKey.charAt(slow) == 'F') F--;
                else T--;
                slow++;
            }
            ans = Math.max(ans,i-slow+1);
        }
        return ans;
    }

    @Test
    public void test() {
        String answerKey = "TTFTTFTT";
        System.out.println(maxConsecutiveAnswers(answerKey, 1));
    }
}
