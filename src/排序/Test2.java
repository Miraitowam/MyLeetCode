package 排序;

import java.util.*;

/**
 * @description: Given a string, sort it in decreasing order based on the frequency of characters.
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * @return:
 * @Author: M
 * @create: 2022/7/3 21:37
 */

public class Test2 {
    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }
        StringBuffer result = new StringBuffer();
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(frequencySort(s));
    }
}
