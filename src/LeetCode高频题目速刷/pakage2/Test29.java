package LeetCode高频题目速刷.pakage2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @return:
 * @Author: M
 * @create: 2022/10/12 15:30
 */

public class Test29 {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        map.put(0, 0);
        map.put(1, 1);
        if (map.containsKey(n)) return map.get(n);
        int result = (fib(n - 1) + fib(n - 2)) % ((int) 1e9 + 7);
        map.put(n, result);
        return result;
    }

    @Test
    public void test() {
        System.out.println(fib(44));
    }
}
