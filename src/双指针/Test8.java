package 双指针;

/**
 * @description: Given a non-empty array of integers, return the k most frequent elements.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * @return:
 * @Author: M
 * @create: 2022/6/30 11:20
 */

public class Test8 {
    public static int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = topKFrequent(nums, 2);
        for (int number : result) {
            System.out.print(number + " ");
        }
    }
}
