package 树;

import org.junit.Test;

/**
 * @description: Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * @return:
 * @Author: M
 * @create: 2022/8/12 20:39
 */

public class Test30 {
    private Node root = new Node();

    public Test30() {
    }

    //初始化前缀树对象
    private class Node {
        //每一个节点自己都有26个子节点
        Node[] children = new Node[26];
        //标志是否是结束位
        boolean isLeaf;
    }

    //向前缀树中插入字符串word
    public void insert(String word) {
        insert(word, root);
    }

    //向某个节点添加单词
    private void insert(String word, Node node) {
        if (node == null) return;
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        //标志当前字符应该插入到children数组的哪个位置
        int index = word.charAt(0) - 'a';
        if (node.children[index] == null) node.children[index] = new Node();
        insert(word.substring(1), node.children[index]);     //继续添加下一个数
    }

    //查找字符串word是否在前缀树中
    public boolean search(String word) {
        return search(word, root);
    }

    //查找字符串word是否在前缀树中
    private boolean search(String word, Node node) {
        if (node == null) return false;
        if (word.length() == 0) return node.isLeaf; //如果查到最后一个字符那么就判断这个字符是否是终止的
        int index = word.charAt(0) - 'a';
        return search(word.substring(1), node.children[index]);
    }

    //插入的字符串是否是前缀树中的前缀之一
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    //插入的字符串是否是前缀树中的前缀之一
    private boolean startsWith(String prefix, Node node) {
        if (node == null) return false;
        if (prefix.length() == 0) return true;
        int index = prefix.charAt(0) - 'a';
        return startsWith(prefix.substring(1), node.children[index]);
    }

    @Test
    public void test() {
        Test30 test = new Test30();
        test.insert("apple");
        System.out.println(test.search("apple"));
        System.out.println(test.search("app"));
        System.out.println(test.startsWith("app"));
        test.insert("app");
        System.out.println(test.search("app"));
    }
}
