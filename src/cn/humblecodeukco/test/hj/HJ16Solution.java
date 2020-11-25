package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/25 12:30
 * @Version 1.0
 * @Description HJ16
 */
public class HJ16Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] f = bf.readLine().split(" ");
        // money
        int n = Integer.parseInt(f[0]);
        // amount
        int m = Integer.parseInt(f[1]);

        Good[] ls = new Good[m + 1];

        for (int i = 1; i <=m; i++) {
            String[] in = bf.readLine().split(" ");
            Good good = new Good(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
            ls[i] = good;
            if (good.type != 0) {
                if (ls[good.type].a1 == 0) {
                    ls[good.type].a1 = i;
                } else {
                    ls[good.type].a2 = i;
                }
            }
        }
        int[][] dp = new int[m + 1][n / 10 + 1];
        for (int i = 1; i <= m; i++) {
            int v = 0, v1 = 0, v2 = 0, v3 = 0;
            int tempdp = 0, tempdp1 = 0, tempdp2 = 0, tempdp3 = 0;
            // 主体
            v = ls[i].price;
            tempdp = ls[i].price * ls[i].imp;
            if (ls[i].a1 != 0) {
                // 主体加副件1
                v1 = ls[ls[i].a1].price + v;
                tempdp1 = tempdp + ls[ls[i].a1].imp * ls[ls[i].a1].price;
            }
            if (ls[i].a2 != 0) {
                // 主体加副件2
                v2 = ls[ls[i].a2].price + v;
                tempdp2 = tempdp + ls[ls[i].a2].imp * ls[ls[i].a2].price;
            }
            if (ls[i].a1 != 0 && ls[i].a2 != 0) {
                // 主体加副件1，2
                v3 = ls[ls[i].a1].price +  ls[ls[i].a2].price + v;
                tempdp3 = tempdp + ls[ls[i].a1].imp * ls[ls[i].a1].price +
                        ls[ls[i].a2].imp * ls[ls[i].a2].price;
            }

            for (int j = 1; j <= n / 10; j++) {
                dp[i][j] = dp[i - 1][j];
                if (ls[i].type == 0) {
                    if (j >= v / 10 && v != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v / 10] + tempdp);
                    }
                    if (j >= v1 / 10 && v1 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1 / 10] + tempdp1);
                    }
                    if (j >= v2 / 10 && v2 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2 / 10] + tempdp2);
                    }
                    if (j >= v3 / 10 && v3 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3 / 10] + tempdp3);
                    }
                }
            }
        }
        System.out.println(dp[m][n / 10]);
    }
    private static class Good {
        public int price;
        public int imp;
        public int type;
        public int a1 = 0;
        public int a2 = 0;
        public Good(int price, int imp, int type) {
            this.price = price;
            this.imp = imp;
            this.type = type;
        }
    }
}
