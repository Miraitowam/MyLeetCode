package 搜索算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
 * 你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * @return:
 * @Author: M
 * @create: 2022/7/12 21:47
 */

public class Test10 {
    public List<String> restoreIpAddresses(String s) {
        //定义所有可能的地址
        List<String> addresses = new ArrayList<>();
        //定义可能的一个地址
        StringBuffer tempAddress = new StringBuffer();
        //回溯法求所有可能的地址
        backTracing(addresses, tempAddress, s, 0);
        return addresses;
    }

    private void backTracing(List<String> addresses, StringBuffer tempAddress, String s, int k) {
        //定义退出的条件要么被分割的长度为0要么已经分成了4段
        if (s.length() == 0 || k == 4) {
            //分情况讨论，如果k=4，但最后一段刚好满足条件那么就添加
            if (s.length() == 0 && k == 4) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            //截取一段字符串进一步判断其合法性
            String part = s.substring(0, i + 1);
            //如果开头就是0且不是第一位的那么就直接结束循环
            if (part.charAt(0) == '0' && i != 0) {
                break;
            }
            if (Integer.valueOf(part) <= 255) {
                //只要当前地址不为空，那么就在前面加一个.完成拼接
                if (!tempAddress.isEmpty()) {
                    part = '.' + part;
                }
                //先把这部分试着添加进去
                tempAddress.append(part);
                //截取字符串继续递归,得到part之后的部分
                backTracing(addresses, tempAddress, s.substring(i + 1), k + 1);
                //释放part之后的部分，参加下一轮循环
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }

    @Test
    public void test() {
        String s = "0000";
        List<String> list = restoreIpAddresses(s);
        System.out.println(list);
    }
}
