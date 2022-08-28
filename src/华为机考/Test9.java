package 华为机考;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description: 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * @return:
 * @Author: M
 * @create: 2022/8/27 14:41
 */

public class Test9 {
    public int openLock(String[] deadends, String target) {
        Set<String> strings = new HashSet<>();
        for (String s : deadends) strings.add(s);
        if (strings.contains(target)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    String upStr = up(cur, j);
                    String downStr = down(cur, j);
                    if (!strings.contains(upStr)) {
                        if (upStr.equals(target)) return count + 1;
                        queue.offer(upStr);
                        strings.add(upStr);
                    }
                    if (!strings.contains(downStr)) {
                        if (downStr.equals(target)) return count + 1;
                        queue.offer(downStr);
                        strings.add(downStr);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public String up(String code, int index) {
        char[] ch = code.toCharArray();
        if (ch[index] == '9') ch[index] = '0';
        else ch[index] = (char) (ch[index] + 1);
        return new String(ch);
    }

    public String down(String code, int index) {
        char[] ch = code.toCharArray();
        if (ch[index] == '0') ch[index] = '9';
        else ch[index] = (char) (ch[index] - 1);
        return new String(ch);
    }

    @Test
    public void test() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0009";
        System.out.println(openLock(deadends, target));
    }
}
