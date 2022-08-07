package 位运算;

import org.junit.Test;

/**
 * @description: 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * @return:
 * @Author: M
 * @create: 2022/8/2 15:13
 */

public class Test4 {
    //diff &= -diff 得到出 diff 最右侧不为 0 的位，
    // 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
    // 利用这一位就可以将两个元素区分开来。
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        diff &= -diff;
        for (int num : nums) diff ^= num;   //返回的结果是只出现了一次的两个数字异或
        int[] res = new int[2];
        for (int num : nums) {  //  取与为0说明是另外一个不同的数
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(singleNumber(nums));
    }
}
