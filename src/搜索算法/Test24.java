package 搜索算法;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description: 力扣433，补充一道BFS例题
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使start 变化为 end 所需的最少变化次数。
 * 如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列start 默认是有效的，但是它并不一定会出现在基因库中。
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * @return:
 * @Author: M
 * @create: 2022/7/25 22:24
 */

public class Test24 {
    private char[] gene = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        //定义层数
        int step = -1;
        //基因突变对照表
        Set<String> bankSet = new HashSet<>(bank.length);
        for (String tar : bank) bankSet.add(tar);
        //如果对照表中连最终值都没那么肯定是无法到达
        if (!bankSet.contains(end)) return step;
        //核心部分定义一个队列
        Queue<String> queue = new LinkedList<>();
        //核心部分记录是否已经访问
        Set<String> added = new HashSet<>();
        //首先添加第一个元素开启bfs
        queue.offer(start);
        added.add(start);
        while (!queue.isEmpty()) {
            int count = queue.size();
            step++;     //step初始化为-1所以在这里加
            for (int i = 0; i < count; i++) {
                //把队列中每一个值都拿出来比较
                String curStr = queue.poll();
                if (curStr.equals(end)) return step;    //如果当前值满足end那么直接抛出
                //如果不满足那么就试探下一层，将下一层的元素全部添加
                char[] chars = curStr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    //尝试每一个基因进行替换
                    for (char g : gene) {
                        //如果当前的基因并不相等那就进行替换
                        if (c != g) {
                            chars[j] = g;
                            String tmpStr = new String(chars);
                            //现在就开始判断
                            if (tmpStr.equals(end)) return step + 1;//因为是下一层的所以要加1
                            //如果这个节点没被访问恰巧又满足中间节点，那就加入进去
                            if (!added.contains(tmpStr) && bankSet.contains(tmpStr))
                                queue.offer(tmpStr);
                            //将这个新组合的基因加入到已访问
                            added.add(tmpStr);
                        }
                    }
                    //再原封不动的替换回去
                    chars[j] = c;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(start, end, bank));
    }
}
