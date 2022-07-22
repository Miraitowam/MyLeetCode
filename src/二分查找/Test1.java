package 二分查找;

/**
 * @description: 给你一个非负整数 x ，计算并返回x的算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 输入：x = 4
 * 输出：2
 * @return:
 * @Author: M
 * @create: 2022/7/5 21:07
 */
public class Test1 {
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        if (x == 1) return 1;
        int l = 0, r = x;
        while (r - l > 1) {
            int mid = (l + r) >> 1;
            if (x / mid < mid) r = mid;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
}
