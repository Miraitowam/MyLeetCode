package 华为机考;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:\ 答题得分
 * @return:
 * @Author: M
 * @create: 2022/8/26 16:33
 */

public class Test7 {
    public int count(int score) {
        //每道题的得分
        int[] s = new int[25];
        //判断题
        for (int i = 0; i < 10; i++) s[i] = 2;
        //单选
        for (int i = 10; i < 20; i++) s[i] = 4;
        //多选
        for (int i = 20; i < 25; i++) s[i] = 8;
        return dfs(0, score, 3, s);
    }

    public int dfs(int index, int score, int count, int[] s) {
        if (count == 0 || index == 25) return score == 0 ? 1 : 0;
        if (score == 0) return 1;
        //做对和做出错
        return dfs(index + 1, score - s[index], count, s) + dfs(index + 1, score, count - 1, s);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isVisited = new boolean[groupSizes.length];
        for (int i = 0; i < groupSizes.length; i++) {
            ddfs(groupSizes, i, isVisited, res);
        }
        return res;
    }

    public void ddfs(int[] groupSizes, int index, boolean[] isVisited, List<List<Integer>> res) {
        int target = groupSizes[index];
        List<Integer> ans = new ArrayList<>();
        if (index == groupSizes.length || isVisited[index]) return;
        for (int i = index; i < groupSizes.length; i++) {
            if (groupSizes[i] == target) {
                isVisited[index] = true;
                ans.add(i);
            }
            if (ans.size() == target) {
                res.add(new ArrayList<>(ans));
                return;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(count(100));
    }
}
