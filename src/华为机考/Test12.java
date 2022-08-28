package 华为机考;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个正整数数组arr，考虑所有满足以下条件的二叉树：
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组arr中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个32 位整数。
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：
 * 有两种可能的树，第一种的非叶节点的总和为 36，第二种非叶节点的总和为 32。
 * @return:
 * @Author: M
 * @create: 2022/8/27 20:22
 */

public class Test12 {
    public int mctFromLeafValues(int[] arr) {
        List<Integer> array = new ArrayList<>();
        int res = 0;
        int minNum;
        for (int i : arr) array.add(i);
        while (array.size() > 1) {
            minNum = Integer.MAX_VALUE;
            int deleteIndex = -1;
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i) * array.get(i - 1) < minNum) {
                    if (array.get(i) > array.get(i - 1)) deleteIndex = i - 1;
                    else deleteIndex = i;
                }
                minNum = Math.min(minNum, array.get(i) * array.get(i - 1));
            }
            array.remove(deleteIndex);
            res += minNum;
        }
        return res;
    }
}
