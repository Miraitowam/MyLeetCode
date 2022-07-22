package 数学;

/**
 * @description: 对于 a 和 b 的最大公约数 f(a, b)，有：
 * 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
 * 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
 * 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
 * 如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
 * 乘 2 和除 2 都可以转换为移位操作。
 * @return:
 * @Author: M
 * @create: 2022/7/17 19:21
 */

public class Test3 {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
