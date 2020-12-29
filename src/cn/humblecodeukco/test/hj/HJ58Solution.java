package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/29 10:38
 * @Version 1.0
 * @Description HJ58 输入n个整数，输出其中最小的k个
 */
public class HJ58Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String[] conf = str.split(" ");
            int num = Integer.parseInt(conf[0]);
            int k = Integer.parseInt(conf[1]);
            int[] nums = new int[num];
            str = read.readLine();
            String[] numbers = str.split(" ");
            for (int i = 0; i < numbers.length; ++i) { nums[i] = Integer.parseInt(numbers[i]); }
            Arrays.sort(nums);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; ++i) { sb.append(nums[i]).append(" "); }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
