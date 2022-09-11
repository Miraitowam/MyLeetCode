package 上机真题;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();   //数据组数
        in.nextLine();
        int[][] people = new int[T][(int)1e9];
        int[] choice = new int[123456];
        String[] sex = new String[123456];
        //每次处理一组数据
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();   //已有用餐的长度
            in.nextLine();
            String p = in.nextLine();
            for (int j = 0; j < N; j++) people[i][j] = p.charAt(j) - '0';
            choice[i] = N;  //选择数
            in.nextLine();
            sex[i] = in.nextLine();
        }
        for (int i = 0; i < T; i++) {
            choose(people[i], choice[i], sex[i]);
        }
    }

    public static void choose(int[] people, int choice, String sex) {
        for (int i = 0; i < sex.length(); i++) {
            char c = sex.charAt(i);
            boolean isV = isValid(people, choice);
            boolean isM = isMoreThanZero(people, choice);   //是否都坐了人
            if (c == 'M') {    //是男性
                for (int j = 0; j < people.length; j++) {
                    if (people[j] == 2) continue;
                    if (isV) {  //全部为空或者坐满
                        if (people[j] == 0) {
                            people[j]++;
                            System.out.println(j + 1);
                            break;
                        }
                    } else {
                        if (people[j] == 1) {
                            people[j]++;
                            System.out.println(j + 1);
                            break;
                        }
                    }
                }
            } else {    //是女性
                for (int j = 0; j < people.length; j++) {
                    if (people[j] == 2) continue;
                    if (isM) {
                        if (people[j] == 1) {
                            people[j]++;
                            System.out.println(j + 1);
                            break;
                        }
                    } else {
                        if (people[j] == 0) {
                            people[j]++;
                            System.out.println(j + 1);
                            break;
                        }
                    }
                }
            }
        }
    }

    //判断是否都空着或者都是两个人
    public static boolean isValid(int[] people, int choice) {
        int countTwo = 0, countZero = 0;
        for (int i = 0; i < choice; i++) {
            if (people[i] == 0) countZero++;
            if (people[i] == 2) countTwo++;
        }
        return countTwo == choice || countZero == choice || countTwo + countZero == choice;
    }

    //判断是否都至少一人
    public static boolean isMoreThanZero(int[] people, int choice) {
        int count = 0;
        for (int i = 0; i < choice; i++) if (people[i] > 0) count++;
        return count == choice;
    }
}
