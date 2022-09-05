import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");
        String word1 = words[0];
        String word2 = words[1];
        int[] map = new int[26];
        for (char c : word1.toCharArray()) map[c - 'a']++;
        for (char c : word2.toCharArray()) map[c - 'a']--;
        for (int i = 0; i < map.length; i++) {
            char ans = (char) (97 + i);
            if (map[i] == -1) System.out.println(ans);
        }
    }
}
