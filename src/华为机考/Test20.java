package 华为机考;

import org.junit.Test;

/**
 * @description: 获得KMP算法的next数组
 * @return:
 * @Author: M
 * @create: 2022/8/28 22:31
 */

public class Test20 {
    public int[] getNext(String s) {
        int j = 0;
        int[] next = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == s.charAt(j)) next[i] = ++j;
        }
        return next;
    }

    @Test
    public void test() {
        String s = "aabaaf";
        getNext(s);
    }
}
