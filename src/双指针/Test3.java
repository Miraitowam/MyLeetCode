package 双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: Write a function that takes a string as input and reverse only the vowels of a string.
 * Input: "hello"
 * Output: "holle"
 * @return:
 * @Author: M
 * @create: 2022/6/29 21:40
 */

public class Test3 {
    static HashSet vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (vowels.contains(ci) & vowels.contains(cj)) {
                result[i++] = cj;
                result[j--] = ci;
            } else if (vowels.contains(ci) & !vowels.contains(cj)) {
                result[j--] = cj;
            } else if (!vowels.contains(ci) & vowels.contains(cj)) {
                result[i++] = ci;
            } else {
                result[i++] = ci;
                result[j--] = cj;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String words = "hello";
        System.out.println(Test3.reverseVowels(words));
    }
}
