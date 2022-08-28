package 华为机考;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 分配存款
 * @return:
 * @Author: M
 * @create: 2022/8/26 14:53
 */

public class Test6 {
    public int[] distribute(int money, int[] villager) {
        Arrays.sort(villager);
        int finalLen = 0, curMoney;
        int finalMoney = money;
        for (int i = villager.length - 1; i >= 0; i--) {
            curMoney = money;
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (villager[i] - villager[j] > curMoney) break;
                else {
                    curMoney = curMoney - (villager[i] - villager[j]);
                    count++;
                    if (count > finalLen) finalMoney = Math.min(finalMoney, curMoney);
                    finalLen = Math.max(finalLen, count);
                }
            }
        }
        return new int[]{finalLen, finalMoney};
    }

    @Test
    public void test() {
        int[] villager = {10,3,1};
        System.out.println(distribute(8, villager));
    }
}
