package 双指针;

/**
 * @description: Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * For example,
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * @return:
 * @Author: M
 * @create: 2022/6/29 22:24
 */

public class Test4 {
    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i + 1, j - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String words = "aba";
        System.out.println(validPalindrome(words));
    }
}
