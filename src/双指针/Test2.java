package 双指针;

/**
 * @description: Given a non-negative integer c , your task is to decide whether there're two integers a and b
 * such that a^2 + b^2 = c
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * @return:
 * @Author: M
 * @create: 2022/6/29 21:22
 */

public class Test2 {
    static boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int i = 0, j = (int) Math.sqrt(target);
        while (i < j) {
            int sum = i * i + j * j;
            if (sum == target) {
                return true;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int target = 6;
        boolean result = Test2.judgeSquareSum(target);
        System.out.println(result);
    }
}
