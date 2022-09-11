package LeetCode高频题目速刷.pakage1;

import org.junit.Test;

/**
 * @description: 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * @return:
 * @Author: M
 * @create: 2022/9/5 20:14
 */

public class Test23 {
    //超时
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) continue;
            if (dfs(gas, cost, 0, i, i)) return i;
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (sum < 0) return -1;
        return start;
    }

    public boolean dfs(int[] gas, int[] cost, int curGas, int start, int cur) {
        int curPos = cur % gas.length;
        if (curGas + gas[curPos] < cost[curPos]) return false;
        if (cur > start && curPos == start) return true;  //绕一圈回来了
        curGas += gas[curPos];
        for (int i = cur; i < 2 * gas.length; i++) {
            if (dfs(gas, cost, curGas - cost[curPos], start, i + 1)) return true;
            else return false;
        }
        return false;
    }

    @Test
    public void test() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
