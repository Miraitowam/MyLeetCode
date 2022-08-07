package 动态规划;

import org.junit.Test;

/**
 * @description: 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * @return:
 * @Author: M
 * @create: 2022/8/6 20:31
 */

public class letCode1049 {
    public int lastStoneWeightII(int[] stones) {
        //问题转换为一大堆石头分成两半，一半取正数一半取负数
        int sum = 0, minWeight = Integer.MAX_VALUE;
        for (int stone : stones) {
            sum += stone;
            minWeight = Math.min(stone, minWeight);
        }
        //dp_ij表示前i块石头能放到容量为j的最大值
        int[][] dp = new int[stones.length + 1][sum / 2 + 1];
        for (int i = 1; i <= stones.length; i++) {  //先选石头后选背包
            for (int j = minWeight; j <= sum / 2; j++) {
                if (stones[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return sum - 2 * dp[dp.length - 1][dp[0].length - 1];
    }

    //换一种方法写
    public int lastStoneWeight(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        //dp_ij表示前i块石头能放到容量为j的最大值
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[sum / 2];
    }

    @Test
    public void test() {
        int[] stones = {31, 26, 33, 21, 40};    //5
        int[] stones1 = {2, 7, 4};    //1
        System.out.println(lastStoneWeight(stones));
        System.out.println(lastStoneWeight(stones1));
    }
}
