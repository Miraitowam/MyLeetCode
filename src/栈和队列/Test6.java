package 栈和队列;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），返回nums中每个元素的 下一个更大元素 。
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2
 * @return:
 * @Author: M
 * @create: 2022/7/21 16:30
 */

public class Test6 {
    public int[] nextGreaterElements(int[] nums) {
        //定义结果集
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        //循环两遍
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i % nums.length];
            //说明出现了比之前压入栈的元素更大的值
            while (!stack.isEmpty() && temp > nums[stack.peek()]) res[stack.pop()] = temp;
            if (i < nums.length) stack.push(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
