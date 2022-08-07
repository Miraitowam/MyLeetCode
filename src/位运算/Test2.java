package 位运算;

import org.junit.Test;

/**
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @return:
 * @Author: M
 * @create: 2022/8/2 14:51
 */

public class Test2 {
    //交换律：a ^ b ^ c <=> a ^ c ^ b
    //任何数于0异或为任何数 0 ^ n => n
    //相同的数异或为0: n ^ n => 0
    public int singleNumber(int[] nums) {
        int cur = 0;
        for (int n : nums) cur = cur ^ n;
        return cur;
    }

    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
