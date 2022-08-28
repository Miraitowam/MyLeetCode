package 滑动窗口;

import org.junit.Test;

/**
 * @description: 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * @return:
 * @Author: M
 * @create: 2022/8/25 15:12
 */

public class Test3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) map[s1.charAt(i) - 'a']++;
        //先统计一段s1长度的
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) map1[s2.charAt(i) - 'a']++;
        int left = 0, right = s1.length();
        while (right < s2.length()) {
            if (isSame(map, map1)) return true;
            map1[s2.charAt(left++) - 'a']--;
            map1[s2.charAt(right++) - 'a']++;
        }
        return isSame(map, map1);
    }

    public boolean isSame(int[] map, int[] map1) {
        for (int i = 0; i < 26; i++) if (map[i] != map1[i]) return false;
        return true;
    }

    @Test
    public void test() {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }
}
