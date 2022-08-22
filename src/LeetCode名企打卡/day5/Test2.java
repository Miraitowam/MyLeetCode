package LeetCode名企打卡.day5;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i个火柴棒的长度。
 * 你要用 所有的火柴棍拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * @return:
 * @Author: M
 * @create: 2022/8/20 22:13
 */

public class Test2 {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int len : matchsticks) sum += len;
        if (sum % 4 != 0) return false;
        int average = sum / 4;
        for (int len : matchsticks) if (len > average) return false;
        boolean[] isVisited = new boolean[matchsticks.length];
        return dfs(matchsticks, 0, average, new int[4],isVisited);
    }

    public boolean dfs(int[] matchsticks, int index, int target, int[] size, boolean[] isVisited) {
        if (index == matchsticks.length) {
            //如果火柴都访问完了，并且size的4个边的长度都相等，说明是正方形，直接返回true，
            //否则返回false
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3])
                return true;
            return false;
        }
        //到这一步说明火柴还没访问完
        for (int i = 0; i < size.length; i++) {
            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过
            if (size[i] + matchsticks[index] > target) continue;
            if (isVisited[index]) continue;
            //如果当前火柴放到size[i]这个边上，长度不大于target，我们就放上面
            size[i] += matchsticks[index];
            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            isVisited[index] = true;
            if (dfs(matchsticks, index + 1, target, size, isVisited)) return true;
            //如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            //size[i]这个边上给移除，然后在试其他的边
            size[i] -= matchsticks[index];
            isVisited[index] = false;
        }
        //如果不能构成正方形，直接返回false
        return false;
    }

    @Test
    public void test() {
        int[] matchsticks = {4,13,1,1,14,15,1,3,13,1,3,5,2,8,12};
        System.out.println(makesquare(matchsticks));
    }
}
