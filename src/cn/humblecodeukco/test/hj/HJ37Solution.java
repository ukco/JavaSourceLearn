package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/13 11:37
 * @Version 1.0
 * @Description HJ37
 */
public class HJ37Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int month = Integer.parseInt(str);
            System.out.println(getTotalCount(month));
        }
    }
    public static int getTotalCount(int month) {
        if (month < 3) { return 1; }
        return getTotalCount(month - 2) + getTotalCount(month - 1);
    }

    public static int getTotalCount2(int month) {
        int k1 = 0, k2 = 0, k3 = 0;
        for (int i = 0; i < month; ++i) {
            k3 = k3 + k2;
            k2 = k1;
            if (k2 == 0 && k3 == 0) { k1 = 1; }
            else if (k2 == 1 && k3 == 0) { k1 = 0; }
            else { k1 = k3;}
        }
        return k1 + k2 + k3;
    }
}
