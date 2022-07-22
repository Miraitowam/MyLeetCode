package 搜索算法;

import org.junit.Test;

import java.util.*;

/**
 * @description: 127
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列beginWord -> s1-> s2-> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在wordList中。
 * sk== endWord
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0 。
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * @return:
 * @Author: M
 * @create: 2022/7/10 16:18
 */

public class Test3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //首先将wordList转换为set这样就可以用contains函数判断是否含有
        Set<String> words = new HashSet(wordList);
        //假如wordlist没有endWord直接返回
        if (!words.contains(endWord)) {
            return 0;
        }
        //定义一个队列用以存储所有访问的节点
        Queue<String> nodes = new LinkedList<>();
        //定义搜索的层数
        int level = 1;
        //将第一个单词加入到队列中
        nodes.offer(beginWord);
        //不停地遍历直到队列中元素都被访问到
        while (!nodes.isEmpty()) {
            //获取需要遍历的节点个数
            int size = nodes.size();
            //每遍历一次level就加1
            level++;
            //只要还有元素就一直遍历
            while (size-- > 0) {
                //取出队列头元素
                String cur = nodes.poll();
                //需要遍历的次数
                for (int i = 0; i < cur.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        //一个一个替换字母来创造新单词
                        String newWord = cur.substring(0, i) + j + cur.substring(i + 1);
                        //如果查到包含这个新单词就意味着这两个单词之间存在通路
                        if (words.contains(newWord)) {
                            nodes.offer(newWord);
                            //删除单词表中这个单词避免重复
                            words.remove(newWord);
                        }
                        //如果找到的这新单词就是end那么直接就返回结果
                        if (newWord.equals(endWord)) {
                            return level;
                        }
                    }
                }
            }
        }
        //默认返回值
        return 0;
    }

    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(list.clone());
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
