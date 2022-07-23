package 栈和队列;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈经典题目
 *
 * @description: 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * @return:
 * @Author: M
 * @create: 2022/7/21 16:29
 */

public class Test5 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            //求距离就是两个点索引之差
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            //将步数添加进去
            stack.push(i);
        }
        return ans;
    }

    //496. 下一个更大元素 I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //用来记录对应num2下一个更大的数
        int[] ans = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) res[i] = ans[j];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
        int[] nums1 = {2,4}, nums2 = {8, 2, -1, 4};
        int[] res2 = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res2));
    }
}
