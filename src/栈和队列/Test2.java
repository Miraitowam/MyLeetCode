package 栈和队列;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * @Author: M
 * @create: 2022/7/21 16:28
 */

public class Test2 {
    class MyStack {
        private Queue<Integer> in;//输入队列
        private Queue<Integer> out;//输出队列


        public MyStack() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void push(int x) {
            out.offer(x);
            while (!in.isEmpty()) out.offer(in.poll());
            Queue temp = in;
            in = out;
            out = temp;
            System.out.println(in);
        }

        public int pop() {
            return in.poll();
        }

        public int top() {
            return in.peek();
        }

        public boolean empty() {
            return in.isEmpty();
        }
    }

    @Test
    public void test(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
    }
}
