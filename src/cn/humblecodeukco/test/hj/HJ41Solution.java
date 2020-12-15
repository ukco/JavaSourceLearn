package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/15 22:00
 * @Version 1.0
 * @Description HJ41
 */
public class HJ41Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mark;
        while ((mark = reader.readLine()) != null) {
            int n = Integer.parseInt(mark);
            String[] s1 = reader.readLine().split(" ");
            String[] s2 = reader.readLine().split(" ");
            int[] weight = new int[s1.length];
            int[] nums = new int[s2.length];
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                weight[i] = Integer.parseInt(s1[i]);
                nums[i] = Integer.parseInt(s2[i]);
                sum += weight[i] * nums[i];
            }
            System.out.println(fama(n, weight, nums, sum));
        }
    }
    private static int fama(int n, int[] weight, int[] nums, int sum) {
        boolean[] weg = new boolean[sum + 1];
        weg[0] = true;
        weg[sum] = true;
        int top = 0;
        // 三重循环，分别表示 n个砝码，weight.length 个种类，每个种类有 num.length 个数量
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                for (int k = top + weight[i]; k >= weight[i]; --k) {
                    // weg[k-weight[i]]== true,意思就是 k-weight[i] + weight[i] == k,可以称出 k 重量
                    if (weg[k - weight[i]]) { weg[k] = true; }
                }
                top += weight[i];
            }
        }
        int count = 0;
        for (boolean b: weg) { if (b) { ++count; }}
        return count;
    }
}
