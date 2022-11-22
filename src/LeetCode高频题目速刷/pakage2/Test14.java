package LeetCode高频题目速刷.pakage2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @return:
 * @Author: M
 * @create: 2022/9/12 19:28
 */

public class Test14 {

    class LRUCache {
        public int capacity;
        private Map<Integer, Integer> map = new LinkedHashMap<>();  //双向的

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);        //保证每次查询之后都放在最末尾
                map.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) map.remove(key);
            else if (map.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                it.next();
                it.remove();
            }
            map.put(key, value);
        }
    }
}
