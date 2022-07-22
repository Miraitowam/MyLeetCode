package 双指针;

import java.util.Arrays;
import java.util.List;

/**
 * @description: Given a string and a string dictionary, find the longest string in the dictionary that can be formed
 * by deleting some characters of the given string. If there are more than one possible results,
 * return the longest word with the smallest lexicographical order. If there is no possible result,
 * return the empty string
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * @return:
 * @Author: M
 * @create: 2022/6/29 22:37
 */

public class Test6 {
    public static String findLongestWord(String s, List<String> d) {
        String longsword = "";
        for (String str : d) {
            int l1 = longsword.length(), l2 = str.length();
            if (l1 > l2 || (l1 == l2 && !d.equals(longsword))) {
                continue;
            }
            if (isSubstr(s, str)) {
                longsword = str;
            }
        }
        return longsword;
    }

    public static boolean isSubstr(String s, String str) {
        int i = 0, j = 0;
        while (i < s.length() && j < str.length()) {
            char ci = s.charAt(i);
            char cj = str.charAt(j);
            i++;
            if (cj == ci) {
                j++;
            }
        }
        if (j == str.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List list = Arrays.asList("ale", "apple", "monkey", "plea");
        String str = "abpcplea";
        System.out.println(findLongestWord(str, list));
    }
}
