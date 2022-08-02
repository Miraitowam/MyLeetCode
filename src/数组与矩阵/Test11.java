package 数组与矩阵;

import org.junit.Test;

/**
 * @description: 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }
 * 且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * @return:
 * @Author: M
 * @create: 2022/8/1 20:16
 */

public class Test11 {
    public int arrayNesting(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int curNum = i, count = 0;
            //找到以i为起点的环的长度
            while (nums[curNum] != -1) {     //遍历过的数会被标记为-1
                count++;
                int temp = curNum;
                curNum = nums[curNum];
                nums[temp] = -1;    //已访问设置为-1
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] A = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(A));
    }
}
