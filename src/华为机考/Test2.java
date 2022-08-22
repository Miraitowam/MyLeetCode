package 华为机考;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。
 * 他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 * 请你帮助王强计算可获得的最大的满意度。
 * @return:
 * @Author: M
 * @create: 2022/8/22 11:16
 */

public class Test2 {
    public int maxSatisfaction(int money, int num, int[][] shoppingList) {
        //由于物品都是10的整数倍，因此可以使用dp
        int[][] dp = new int[num + 1][money / 10 + 1];
        //主件满意度,主件加附件1，主件加附件2，主件加附件1和2，附件一价格，附件二价格。
        int[][] values = getValues(shoppingList);
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (shoppingList[i - 1][2] == 0) {  //是主件
                    //主件价格,满意度
                    int a = shoppingList[i - 1][0], b = values[i - 1][0];
                    //主件附件1价格，满意度
                    int c = values[i - 1][4], d = values[i - 1][1];
                    //主件附件2价格，满意度
                    int e = values[i - 1][5], f = values[i - 1][2];
                    //买主件还是不买
                    if (10 * j >= a) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a / 10] + b);
                    else dp[i][j] = dp[i - 1][j];
                    //买主件1还是保持
                    if (10 * j >= a + c) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (a + c) / 10] + b + d);
                    //买主件2还是保持
                    if (10 * j >= a + e) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (a + e) / 10] + b + f);
                    //买全部还是保持
                    if (10 * j >= a + c + e)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (a + c + e) / 10] + b + d + f);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[num][dp[0].length - 1];
    }

    //生成价值矩阵
    public int[][] getValues(int[][] shoppingList) {
        //主件满意度,主件加附件1，主件加附件2，主件加附件1和2，附件一价格，附件二价格，
        int[][] values = new int[shoppingList.length][6];
        for (int i = 0; i < values.length; i++) {
            if (shoppingList[i][2] == 0) {
                values[i][0] = shoppingList[i][0] * shoppingList[i][1];
            } else {
                if (values[shoppingList[i][2] - 1][1] == 0)
                    values[shoppingList[i][2] - 1][1] = shoppingList[i][0] * shoppingList[i][1];
                else values[shoppingList[i][2] - 1][2] = shoppingList[i][0] * shoppingList[i][1];
                if (values[shoppingList[i][2] - 1][4] == 0) values[shoppingList[i][2] - 1][4] = shoppingList[i][0];
                else values[shoppingList[i][2] - 1][5] = shoppingList[i][0];
            }
            values[i][3] = values[i][1] + values[i][2];
        }
        return values;
    }

    @Test
    public void test() {
//        int[][] shoppingList = {{20, 3, 5}, {20, 3, 5}, {10, 3, 0}, {10, 2, 0}, {10, 1, 0}};//130
        int[][] shoppingList = {{100, 3, 0}, {400, 5, 0}, {300, 5, 0}, {1400, 2, 0}, {500, 2, 0}, {800, 2, 4}, {1400, 5, 4},
                {300, 5, 0},
                {1400, 3, 8},
                {500, 2, 0},
                {1800, 4, 0},
                {440, 5, 10}};//2200
        System.out.println(maxSatisfaction(4500, 12, shoppingList));
    }
}
