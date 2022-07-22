package 双指针;

/**
 * @description: Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 * @return:
 * @Author: M
 * @create: 2022/6/29 20:45
 */

public class Test1 {
    static int[] towSum(int[] numbers, int terget) {
        if (numbers == null) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == terget) {
                return new int[]{i + 1, j + 1};
            } else if (sum > terget) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] result = Test1.towSum(numbers, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
