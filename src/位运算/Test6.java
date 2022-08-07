package 位运算;

import org.junit.Test;

public class Test6 {

    //不使用额外变量交换两个整数
    public void swift(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    @Test
    public void test() {
        int  a = 2, b = 3;
        swift(a, b);
        System.out.println("a:" + a + " " + "b:" + b);
    }
}
