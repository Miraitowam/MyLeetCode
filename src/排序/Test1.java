package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 桶排序实现
 * @description: Given a non-empty array of integers, return the k most frequent elements
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * @return:
 * @Author: M
 * @create: 2022/7/3 20:34
 */

public class Test1 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2, 3, 3, 3, 3, 5, 6, 6};
        int k = 3;
        int[] result = topKFrequent(numbers, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
