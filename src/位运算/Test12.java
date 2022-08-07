package 位运算;

import org.junit.Test;

/**
 * @description: 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。
 * 如果不存在这样的两个单词，返回 0 。
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * @return:
 * @Author: M
 * @create: 2022/8/2 20:01
 */

public class Test12 {
    public int maxProduct(String[] words) {
        //由于每个单词只含有小写字母，因此可以因32位的整形数组来标记是否含有某个字母
        int[] mark = new int[words.length];
        //逐次标记
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                mark[i] = mark[i] | (1 << c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                //说明不含有相同的字母
                if ((mark[i] & mark[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }
}
