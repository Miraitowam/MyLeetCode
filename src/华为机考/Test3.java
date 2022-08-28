package 华为机考;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description:
 * @return: 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * @Author: M
 * @create: 2022/8/22 21:38
 */

public class Test3 {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) > o2.charAt(0)) return -1;
                else if (o1.charAt(0) < o2.charAt(0)) return 1;
                else {
                    if (o1.length() == o2.length()) return -o1.compareTo(o2);
                    else return (o1 + o2).compareTo(o2 + o1);
                }
            }
        });
        StringBuffer res = new StringBuffer();
        for (String s : str) res.append(s);
        String ans = res.toString();
        if (ans.charAt(0) == '0') return "0";
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[][] nums = new int[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            String[] s1 = in.nextLine().split(",");
            for (int i = 0; i < n; i++) nums[count][i] = Integer.parseInt(s1[i]);
            count++;
        }
        System.out.println(findTarget(nums, k));
    }

    public static int findTarget(int[][] nums, int k) {
        return 0;
    }

    @Test
    public void test() {
        int[] nums = {8308, 8308, 830};
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
            System.out.println(largestNumber(nums));
    }
}
