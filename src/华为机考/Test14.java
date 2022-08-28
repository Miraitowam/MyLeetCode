package 华为机考;

import org.junit.Test;

public class Test14 {
    public boolean lemonadeChange(int[] bills) {
        int[] bill = new int[3];
        if (bills[0] == 5) bill[0] = 1;
        else if (bills[0] == 10) bill[1] = 1;
        else bills[2] = 1;
        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) bill[0]++;
            else if (bills[i] == 10) {
                bill[1]++;
                if (bill[0] > 0) bill[0] -= 1;
                else return false;
            } else {
                bill[2]++;
                if (bill[1] > 0) {
                    bill[1]--;
                    if (bill[0] > 0) bill[0] -= 1;
                    else return false;
                } else {
                    if (bill[0] > 2) bill[0] -= 3;
                    else return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] bills = {5,5,5,5,10,5,10,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
