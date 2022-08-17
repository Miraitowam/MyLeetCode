package 模拟面试.day1;

import org.junit.Test;

import java.util.*;


/**
 * @description: 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * @return:
 * @Author: M
 * @create: 2022/8/17 19:19
 */

public class Test2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> res = new ArrayList<>();
        String[] ans = map.keySet().toArray(new String[0]);
        Arrays.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) > map.get(o2)) return -1;
                if (map.get(o1) == map.get(o2)) return o1.compareTo(o2);
                return 1;
            }
        });
        for (int i = 0; i < k; i++) {
            res.add(ans[i]);
        }
        return res;
    }

    @Test
    public void test() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 4));
    }
}
