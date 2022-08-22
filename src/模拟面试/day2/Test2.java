package 模拟面试.day2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，
 * 则在 chars 数组中会被拆分为多个字符
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * @return:
 * @Author: M
 * @create: 2022/8/19 15:58
 */

public class Test2 {
    public int compress(char[] chars) {
        int count = 1;
        StringBuffer stringBuffer = new StringBuffer();
        char mark = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (mark == chars[i]) count++;
            else {
                stringBuffer.append(mark);
                if (count != 1) stringBuffer.append(count);
                mark = chars[i];
                count = 1;
            }
        }
        stringBuffer.append(mark);
        if (count != 1) stringBuffer.append(count);
        Arrays.fill(chars,' ');
        for (int i = 0; i < stringBuffer.length(); i++) {
            chars[i] = stringBuffer.charAt(i);
        }
        return stringBuffer.length();
    }

    @Test
    public void test() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'c', 'c'};
        System.out.println(compress(chars));
    }
}
