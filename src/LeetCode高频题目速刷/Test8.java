package LeetCode高频题目速刷;

import org.junit.Test;

import java.util.Arrays;

public class Test8 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        Arrays.sort(m);
        Arrays.sort(r);
        int slow = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] == r[slow]) slow++;
            if (slow == r.length) break;
        }
        return slow == ransomNote.length();
    }

    @Test
    public void test() {
        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
