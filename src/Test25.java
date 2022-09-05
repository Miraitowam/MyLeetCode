import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int ant = in.nextInt();
        int[][] quJ = new int[ant][2];
        for (int i = 0; i < ant; i++) {
            for (int j = 0; j < 2; j++) {
                quJ[i][j] = in.nextInt();
            }
        }
        Arrays.sort(quJ, Comparator.comparingInt(o -> o[0]));
        int end = quJ[0][1];
        //算覆盖率
        for (int i = 0; i < quJ.length; i++) {
            if (quJ[i][0] <= end) {
                end = Math.max(end, quJ[i][1]);
                continue;
            }
        }
        //算要多少只
        Arrays.sort(quJ, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, endPoint = quJ[0][1];
        for (int i = 0; i < quJ.length; i++) {
            if (quJ[i][0] < endPoint) continue;
            cnt++;
            endPoint = quJ[i][1];
        }
        if (end == length) System.out.println(cnt);
        else System.out.println("fail");
    }
}