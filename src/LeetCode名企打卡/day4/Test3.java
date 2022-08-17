package LeetCode名企打卡.day4;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 * @return:
 * @Author: M
 * @create: 2022/8/17 14:22
 */

public class Test3 {
    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] dateForCal = date.split("-");
        int y = Integer.parseInt(dateForCal[0]);
        int m = Integer.parseInt(dateForCal[1]);
        int d = Integer.parseInt(dateForCal[2]);
        int res = 0;
        //加上月份
        for (int i = 0; i < m - 1; i++) {
            //先判断是否是闰年
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) res += leap[i];
            else res += month[i];
        }
        return res + d;
    }

    @Test
    public void test() {
        String date = "2019-02-10";
        System.out.println(dayOfYear(date));
    }
}
