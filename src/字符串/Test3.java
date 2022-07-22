package 字符串;

import org.junit.Test;

/**
 * @description: s = "I am a student"
 * Return "student a am I"
 * @return:
 * @Author: M
 * @create: 2022/7/19 15:39
 */

public class Test3 {
    public String reverse(String words) {
        String[] wordSpilt = words.split(" ");
        words = "";
        for (int i = wordSpilt.length - 1; i >= 0; i--) {
            words += wordSpilt[i];
            if (i != 0) words += " ";
        }
        return words;
    }
    @Test
    public void test(){
        System.out.println(reverse("I am a student"));
    }
}
