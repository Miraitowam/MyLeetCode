package 数组与矩阵;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * 假设该列表是 answer =[a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 * 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * @return:
 * @Author: M
 * @create: 2022/7/31 21:56
 */

public class Test8 {
    //问题转换为翻转数组：n=5的情况为例
    //k=1->1,2,3,4,5    k=2->1,5,4,3,2
    //k=3->1,5,2,3,4    k=4->1,5,2,4,3
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = i + 1; //初始化
        int temp, index;
        for (int j = 1; j <= k; j++) {
            index = n;
            for (int i = j - 1; i < index; i++) {
                temp = res[--index];
                res[index] = res[i];
                res[i] = temp;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] res = constructArray(5, 2);
        System.out.println(Arrays.toString(res));
    }
}
