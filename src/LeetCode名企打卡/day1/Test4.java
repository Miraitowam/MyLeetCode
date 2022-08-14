package LeetCode名企打卡.day1;

import org.junit.Test;

/**
 * @description: 给你两个正整数 n 和 k，二进制字符串 Sn 的形成规则如下：
 * S1= "0"
 * 当 i > 1 时，Si=Si-1+ "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * S1= "0"
 * S2= "011"
 * S3= "0111001"
 * S4 = "011100110110001"
 * 请你返回 Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * @return:
 * @Author: M
 * @create: 2022/8/13 22:47
 */

public class Test4 {
    StringBuffer sb = new StringBuffer();

    public char findKthBit(int n, int k) {
        sb.append("0");
        addStr(n - 1);
        System.out.println(sb);
        return sb.charAt(k - 1);
    }

    //添加字符串
    public void addStr(int k) {
        if (k == 0) return;
        String temp = sb.toString();
        //先添加1
        sb.append("1");
        //替换
        temp = temp.replace("1", "a");
        temp = temp.replace("0", "1");
        temp = temp.replace("a", "0");
        //添加翻转
        sb.append(new StringBuffer(temp).reverse());
        addStr(k - 1);
    }

    @Test
    public void test() {
        System.out.println(findKthBit(4, 11));
    }
}
