package 贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * @return:
 * @Author: M
 * @create: 2022/7/5 14:55
 */

public class Test11 {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {    //得到每一个字符最后出现的位置
            map[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, map[chars[i] - 'a']);
            if (i == idx) { //说明现在正是最后一个字母
                list.add(idx - last);
                last = idx;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result);
    }
}
