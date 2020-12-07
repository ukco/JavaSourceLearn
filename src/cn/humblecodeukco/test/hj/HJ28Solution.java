package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/7 9:36
 * @Version 1.0
 * @Description HJ28
 */
public class HJ28Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while (null != (string = reader.readLine())) {
            int n = Integer.parseInt(string);
            String[] strings = reader.readLine().split(" ");
            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(strings[i]);
                if (tmp % 2 == 0) { evens.add(tmp); }
                else { odds.add(tmp); }
            }
            boolean[] used = new boolean[evens.size()];
            int[] nums = new int[evens.size()];
            int sum = 0;
            for (int i = 0; i < odds.size(); i++) {
                used = new boolean[evens.size()];
                if (find(odds.get(i), evens, used, nums)) { sum++; }
            }
            System.out.println(sum);
        }
    }
    private static boolean find(int x, List<Integer> evens, boolean[] used, int[] nums) {
        for (int i = 0; i < evens.size(); i++) {
            if (isPrime(x + evens.get(i)) && !used[i]) {
                used[i] = true;
                if (nums[i] == 0 || find(nums[i], evens, used, nums)) {
                    nums[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isPrime(int n) {
        if (n % 2 == 0) { return false; }
        for (int i = 3; i <= Math.pow(n, 0.5); i += 2) {
            if (n % i == 0) { return false; }
        }
        return true;
    }
}
