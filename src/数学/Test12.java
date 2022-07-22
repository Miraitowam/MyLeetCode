package 数学;

import org.junit.Test;

/**
 * @description: 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * @return:
 * @Author: M
 * @create: 2022/7/18 17:06
 */

public class Test12 {
    public boolean isPerfectSquare(int num) {
        int init = 1;   //初始平方数
        int diff = 3;   //等差
        while (init < num) {
            init += diff;
            diff += 2;
        }
        System.out.println(init);
        return num == init;
    }

    @Test
    public void test(){
        System.out.println(isPerfectSquare(625));
    }
}
