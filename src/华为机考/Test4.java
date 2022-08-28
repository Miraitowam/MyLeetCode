package 华为机考;

import org.junit.Test;

/**
 * @description: 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 * 现在需要把数组恰好分成 n /2 对，以使每对数字的和都能够被 k 整除。
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * 输出：true
 * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
 * @return:
 * @Author: M
 * @create: 2022/8/25 19:04
 */

public class Test4 {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for(int i:arr)
            mod[(i % k + k) %k]++;
        for(int i=1;i<=k/2;i++) //判断余数是否互补
            if(mod[i] != mod[k -i])
                return false;
        return mod[0] %2 == 0;
    }

    public void getPair(int[] arr, int k, boolean[] isVisited, int start) {
        for (int i = 0; i < arr.length; i++) {
            if (i == start) continue;
            if (isVisited[i]) continue;
            if ((arr[i] + arr[start]) % k == 0) {
                isVisited[i] = true;
                isVisited[start] = true;
                return;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(canArrange(arr, k));
    }
}
