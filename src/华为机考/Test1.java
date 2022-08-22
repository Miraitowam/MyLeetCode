package 华为机考;


import org.junit.Test;

import java.util.*;

public class Test1 {
    public String longestGC(String s, int n) {
        String ans = "";
        int count = 0;
        int curCount;
        for (int i = 0, j = i + n; j <= s.length(); i++, j++) {
            String cur = s.substring(i, j);
            curCount = countCG(cur);
            if (curCount > count) ans = cur;
            count = Math.max(count, curCount);
        }
        return ans;
    }

    public int countCG(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (char c : chars) if (c == 'C' || c == 'G') res++;
        return res;
    }

    @Test
    public void test() {
        String s = "AACTGTGCACGACCTGA";
        System.out.println(longestGC(s, 5));
        Scanner in = new Scanner(System.in);
    }
}
