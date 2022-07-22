import org.junit.Test;

/**
 * @description: 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，
 * 并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
 * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * 输入描述:
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述:
 * 输出转换后的字符串。
 * 示例1
 * 输入
 * 3
 * 12abc-abCAB-c4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * @return:
 * @Author: M
 * @create: 2022/7/20 12:42
 */

public class HOW2 {
    //转换字符串
    public String transform(String s, int k) {
        //如果为空那就直接返回
        if (s == null || s.length() == 0) return null;
        //返回结果
        StringBuffer res = new StringBuffer();
        //找到第一个"-"
        String first = s.substring(0, s.indexOf("-") + 1);
        //将第一个字符串添加到结果
        res.append(first);
        //获得待处理的字符串
        String rest = s.substring(s.indexOf("-") + 1);
        //将待处理的字符串中的"-"删除
        rest = rest.replaceAll("-","");
        //开始遍历并处理
        while (rest.length() > 0) {
            if (rest.length() < k) {
                res.append(toUpperOrLower(rest));
                break;
            }
            //分割并大小写处理
            String temp = toUpperOrLower(rest.substring(0, k));
            res.append(temp + "-");
            rest = rest.substring(k);
        }
        return res.toString();
    }

    //把字符串大小写
    public String toUpperOrLower(String word) {
        int lower = 0, upper = 0;
        for (int i = 0; i < word.length(); i++) {
            //是小写
            if (word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'a' < 26) lower++;
            //是大写
            if (word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'A' < 26) upper++;
        }
        if (lower == upper) return word;
        return lower > upper ? word.toLowerCase() : word.toUpperCase();
    }

    @Test
    public void test() {
        String s = "12abc-abCAB-c4aB@";
        String first = transform(s, 3);
        System.out.println(first);
    }
}
