package LeetCode热题.pakage1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @return: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: M
 * @create: 2022/10/12 14:55
 */

public class Test1 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int count = 0;
        Set<Character> set = new HashSet();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            count = Math.max(count, right - left);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
