package 华为机考;

import java.util.Scanner;

public class Test24 {
    static int n, needed;

    static class nodes {
        private int x, y;

        nodes() {
            x = 0; //距离甲
            y = 0;  //时间
        }
    }

    static nodes a[] = new nodes[20010];
    static int dp[] = new int[20010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        needed = in.nextInt();  //距离
        n = in.nextInt();
        for (int i = 0; i <= n + 10; i++) {
            a[i] = new nodes();
        }
        for (int i = 1; i <= n; i++) {
            a[i].x = in.nextInt();
            a[i].y = in.nextInt();
            a[i].y *= 100;  //等待时间能跑的距离
        }
        a[++n].x = needed;
        a[n].y = 0;
        for (int i = 1; i <= n; i++) dp[i] = (int) 1e9;
        a[0].y = -100;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i].x - a[j].x <= 1000) {
                    dp[i] = Math.min(dp[i], dp[j] + a[j].y + 100 + (a[i].x - a[j].x));
                }
            }
        }
        if (dp[n] != (int) 1e9) System.out.println(dp[n] / 100);
        else System.out.println("-1");
    }
}
