package 贪心算法;

import java.util.Arrays;

/**
 * @description: Assume you are an awesome parent and want to give your children some cookies. But, you
 * should give each child at most one cookie. Each child i has a greed factor gi, which is the
 * minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj
 * >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to
 * maximize the number of your content children and output the maximum number
 * Input: [1,2,3], [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only
 * make the child whose greed factor is 1 content.
 * You need to output 1.
 * @return:
 * @Author: M
 * @create: 2022/7/5 9:43
 */


public class Test1 {
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int g = 0, s = 0;
        while (g < grid.length || s < size.length) {
            if (size[s] >= grid[g]) {
                g++;
            }
            s++;
        }
        return g;
    }

    public static void main(String[] args) {
        int[] grid = {1, 3};
        int[] size = {1, 2, 4};
        System.out.println(findContentChildren(grid, size));
    }
}
