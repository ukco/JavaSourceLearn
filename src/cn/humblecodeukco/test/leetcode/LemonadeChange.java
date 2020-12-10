package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/12/10 9:33
 * @Version 1.0
 * @Description 860
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) { return true; }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; ++i) {
            map.put(bills[i], map.getOrDefault(bills[i], 0) + 1);
            int change = bills[i] - 5;
            if (change == 0) { continue; }
            else if (change == 15) {
                if (map.getOrDefault(10, 0) != 0) {
                    if (map.getOrDefault(5, 0) != 0) {
                        map.put(10, map.get(10) - 1);
                        map.put(5, map.get(5) - 1);
                    } else { return false; }
                } else if (map.getOrDefault(5, 0) != 0 && map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else { return false; }
            }
            else if (change == 5) {
                if (map.getOrDefault(5, 0) == 0) { return false; }
                map.put(5, map.get(5) - 1);
            }
        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        if (bills == null || bills.length == 0) { return true; }
        int[] changes =  new int[3];
        for (int i = 0; i < bills.length; ++i) {
            if (bills[i] == 5) { changes[0] += 1; }
            else if (bills[i] == 10) { changes[1] += 1; }
            else { changes[2] += 1; }

            int change = bills[i] - 5;
            if (change == 5) {
                if (changes[0] == 0) { return false; }
                changes[0] -= 1;
            } else if (change == 15) {
                if (changes[1] != 0 && changes[0] != 0) {
                    changes[1] -= 1;
                    changes[0] -= 1;
                } else if (changes[0] >= 3) { changes[0] -= 3; }
                else { return false; }
            }
        }
        return true;
    }

    public boolean lemonadeChange3(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5) { five++; }
            else if (bill == 10) {
                if (five == 0) { return false; }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) { five -= 3; }
                else { return false; }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[] {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));
    }
}
