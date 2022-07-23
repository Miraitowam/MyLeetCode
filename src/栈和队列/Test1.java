package 栈和队列;

import java.util.Stack;

/**
 * @description: 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * @return:
 * @Author: M
 * @create: 2022/7/21 16:27
 */

public class Test1 {
    //用两个栈实现队列，用一个栈记录数据、一个负责弹出数据
    class MyQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;

        //构造函数
        public MyQueue() {
            //定义一个栈用于进，一个用于出
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        //将in的数据压入到out
        private void in2out() {
            if (out.isEmpty()) {
                while (!in.empty())
                    out.push(in.pop());
            }
        }
    }
}
