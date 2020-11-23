package cn.humblecodeukco.test.hj;

import java.util.*;

/**
 * @Author lyr
 * @Date 2020/11/23 17:15
 * @Version 1.0
 * @Description HJ8
 */
public class HJ8Solution {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int num = cin.nextInt();

        int[] keys = new int[num];
        int[] values = new int[num];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            int key = cin.nextInt();
            int value = cin.nextInt();
            keys[i] = key;
            values[i] = value;
            map.compute(key, (k, v) -> {
                if (v == null) { v = value; }
                else { v += value; }
                return v;
            });
        }
        cin.close();

        List<Map.Entry<Integer, Integer>> listEntry = new ArrayList<>(map.entrySet());
        // Collections.sort(listEntry, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        listEntry.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, Integer> entry : listEntry) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
