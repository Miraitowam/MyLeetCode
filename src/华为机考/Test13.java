package 华为机考;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * @return:
 * @Author: M
 * @create: 2022/8/27 21:26
 */

public class Test13 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    // 当第一列元素不相等时，按第一列降序排列
                    return o2[0] - o1[0];
                } else {
                    // 当第一列元素相等时，按第二列升序排序
                    return o1[1] - o2[1];
                }
            }
        });
        // 新建一个List用于保存结果集
        List<int[]> list = new ArrayList();
        for (int[] temp:people) {
            list.add(temp[1],temp);
        }
        return list.toArray(people);
    }

    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
    }
}
