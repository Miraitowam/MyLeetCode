package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，
 * 永远不会发生碰撞。
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * @return:
 * @Author: M
 * @create: 2022/9/5 16:38
 */

public class Test22 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            //唯一会发生碰撞的情况：栈不为空，栈顶大于0，当前元素小于0
            if (!stack.isEmpty() && stack.peek() > 0 && cur < 0) {
                if (stack.peek() + cur > 0) continue;   //栈顶元素赢
                else {
                    if (!stack.isEmpty() && stack.peek() + cur < 0) {
                        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + cur < 0) stack.pop();
                        if (stack.isEmpty() || stack.peek() < 0) stack.push(cur);
                    } else if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + cur == 0) stack.pop();
                }
            } else stack.push(asteroids[i]);
        }
        int[] res = new int[stack.size()];
        if (!stack.isEmpty()) {
            int t = stack.size() - 1;
            while (!stack.isEmpty()) res[t--] = stack.pop();
        }
        return res;
    }

    @Test
    public void test() {
        int[] asteroids = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
