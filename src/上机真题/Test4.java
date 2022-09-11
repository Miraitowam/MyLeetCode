package 上机真题;

import java.util.*;

public class Test4 {
    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] server = in.nextLine().split(" ");
        int target = in.nextInt();
        int[] serverPort = new int[server.length];
        for (int i = 0; i < server.length; i++) serverPort[i] = Integer.parseInt(server[i]);
        Arrays.sort(serverPort);
        List<Integer> result = new ArrayList<>();
        dfs(serverPort, target, serverPort.length - 1, result,Integer.MAX_VALUE);
        if (res.size() == 0) {
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            min = Math.min(min, res.get(i).size());
        }
        List<List<Integer>> fin = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == min) {
                List<Integer> cur = new ArrayList<>(res.get(i));
                Collections.sort(cur);
                if (!fin.contains(cur)) fin.add(new ArrayList<>(cur));
            }
        }
        for (int i = 0; i < fin.size(); i++) {
            for (int j = 0; j < fin.get(i).size(); j++) {
                System.out.print(fin.get(i).get(j));
                if (j != fin.get(i).size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[] serverPort, int target, int index, List<Integer> result, int min) {
        if (index <= 0 || target <= 0) {
            if (target == 0) {
                if (!res.contains(result)) res.add(new ArrayList<>(result));
            }
            return;
        }
        if (!res.isEmpty()) {
            for (int i = 0; i < res.size(); i++) {
                min = Math.min(min, res.get(i).size());
            }
        }
        if (result.size() > min) return;
        for (int i = serverPort.length - 1; i >= 0; i--) {
            result.add(serverPort[i]);
            dfs(serverPort, target - serverPort[i], i, result, min);
            result.remove(result.size() - 1);
        }
    }
}
