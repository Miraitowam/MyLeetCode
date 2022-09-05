package 上机真题;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = in.nextInt(), max = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = in.nextInt();
        Arrays.sort(scores);
        int taotai = 0, jinji = 0;
        int target = -1;
        for (int i = 0; i < scores.length; i++) {
            taotai = i;
            jinji = scores.length - i - 1;
            if (taotai >= min && taotai <= max && jinji >= min && jinji <= max) {
                target = scores[i];
                break;
            }
        }
        if (target != -1) System.out.println(target);
        else System.out.println(-1);
    }
}
