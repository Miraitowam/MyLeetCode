package 树;

import org.junit.Test;

/**
 * @description: 设计一个 map ，满足以下几点:
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，
 * 那么原来的键值对key-value将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * @return:
 * @Author: M
 * @create: 2022/8/12 21:44
 */

public class Test31 {
    private Node root = new Node();

    public Test31() {
    }

    private class Node {
        Node[] children = new Node[26];
        int val = 0;
    }

    //向某个单词前缀树插入值
    public void insert(String key, int val) {
        insert(key, val, root);
    }

    //向某个单词前缀树插入值
    private void insert(String key, int val, Node node) {
        if (node == null) return;
        if (key.length() == 0) {
            node.val = val;
            return;
        }
        int index = key.charAt(0) - 'a';
        if (node.children[index] == null) node.children[index] = new Node();
        insert(key.substring(1), val, node.children[index]);
    }

    //返回前缀和
    public int sum(String prefix) {
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node) {
        if (node == null) return 0;
        if (prefix.length() != 0) {
            int index = prefix.charAt(0) - 'a';
            return sum(prefix.substring(1), node.children[index]);
        }
        //找到最后一个字母跟着的所有数字
        int sum = node.val;
        for (Node child : node.children) sum += sum(prefix, child);
        return sum;
    }

    @Test
    public void test() {
        Test31 test = new Test31();
        test.insert("apple", 8);
        test.insert("app", 2);
        test.insert("apple", 7);
        System.out.println(test.sum("app"));
    }
}
