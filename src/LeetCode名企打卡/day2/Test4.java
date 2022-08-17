package LeetCode名企打卡.day2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:魔法外卖
 * @return:
 * @Author: M
 * @create: 2022/8/14 20:06
 */

public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        String[] s1 = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]), t = Integer.parseInt(s[1]);
        int[] time = new int[n];
        for (int i = 0; i < n; i++) time[i] = Integer.parseInt(s1[i]);
        Arrays.sort(time);
        int curTime = 0, cont = 0;
        for (int i = 0; i < time.length; i++) {
            if (curTime + t <= time[i]) curTime += t;
            else cont++;
        }
        System.out.println(cont);
    }

}
