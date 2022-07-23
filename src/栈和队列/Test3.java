package 栈和队列;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @return:
 * @Author: M
 * @create: 2022/7/21 16:28
 */

public class Test3 {
    class MinStack {
        //定义最小值栈，最小值
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int min = Integer.MAX_VALUE;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            //找到更小的,这样栈顶永远最小
            min = Math.min(min, val);
            minStack.push(min);
            //数据正常入栈
            dataStack.push(val);
        }

        public void pop() {
            //正常出栈,如果出的恰好是最小值那就一起出
            if (dataStack.peek() == minStack.peek()) {
                minStack.pop();
            }
            dataStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
