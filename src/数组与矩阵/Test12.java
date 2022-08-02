package 数组与矩阵;

import org.junit.Test;

/**
 * @description: 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量。
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * @return:
 * @Author: M
 * @create: 2022/8/1 20:35
 */

public class Test12 {
    public int maxChunksToSorted(int[] arr) {
        int count = 0, right = -1;
        //由于数组只包含[0, n - 1]范围内的数，所以只需要和i比较，如果这个范围内的数都比i小那么可以划分,否则就意味着有更小的数在区间外
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) count++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr = {1, 0, 2, 3, 4};
        System.out.println(maxChunksToSorted(arr));
    }
}
