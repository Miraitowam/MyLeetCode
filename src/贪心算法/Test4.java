package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 406.Queue Reconstruction by Height
 * 题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
 * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @return:
 * @Author: M
 * @create: 2022/7/5 10:48
 */

public class Test4 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0]-o1[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        List<int[]> list = new ArrayList();
        for (int[] temp:people) {
            list.add(temp[1],temp);
        }
        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(reconstructQueue(people));
    }
}
