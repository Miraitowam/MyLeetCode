import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @description: 给定等腰梯形周长n，范围1~10000，要求梯形的上底小于下底，两腰长度相等，上底加两腰长度大于下底，求给定周长下的所有可能的方案。
 * @return:
 * @Author: M
 * @create: 2022/7/25 10:31
 */

public class HOW3 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    //规定
    public List<List<Integer>> getTrapezoid(int n) {
        //如果n<5必然无法形成等腰梯形
        if (n < 5) return null;
        //只用遍历一半
        for (int i = 1; i < n / 2; i++) {
            temp.add(i);//添加上底
            for (int j = 1; j < n / 2; j++) {    //循环遍历腰
                isValid(n, i, j);
            }
            temp.remove(temp.size() - 1);//移除
        }
        return res;
    }

    //回溯法求解所有可能性
    public void isValid(int n, int top, int yao) {
        //定义推出的条件
        int bot = n - 2 * yao - top;  //底边长
        //上底小于下底，上底加两腰长度大于下底
        if (top >= bot || top + 2 * yao <= bot) return;
        temp.add(yao);
        temp.add(bot);
        res.add(new ArrayList<>(temp));
        temp.remove(temp.size() - 1);
        temp.remove(temp.size() - 1);
    }

    @Test
    public void test() {
        System.out.println(getTrapezoid(10));
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(hexToDex(s));
    }

    //HJ3 统计数量
    public static int countWord(String s, String word) {
        String lower = word.toLowerCase();
        String upper = word.toUpperCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lower.equals(s.substring(i, i + 1))) count++;
            if (upper.equals(s.substring(i, i + 1))) count++;
        }
        return count;
    }

    //HJ4字符串分割
    public static void split(String s) {
        //如果字符串大于8那就不断地截取
        while (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            s = s.substring(8);
        }
        //此时s的长度必然小于8
        if (s.length() < 8 && s.length() > 0) {
            s += "00000000";
            System.out.println(s.substring(0, 8));
        }
    }

    //HJ10 字符个数统计
    public static int countChar(String s) {
        Set<Character> count = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            count.add(s.charAt(i));
        }
        return count.size();
    }

    //十六进制转换
    public static int hexToDex(String s) {
        String num = s.substring(2).toUpperCase();  //防止出现小写不匹配
        String hexNum = "0123456789ABCDEF";
        int res = 0;
        int b = 0;//16的次方
        for (int i = num.length() - 1; i >= 0; i--) {
            res += hexNum.indexOf(num.charAt(i)) * Math.pow(16, b++);
        }
        return res;
    }
}
