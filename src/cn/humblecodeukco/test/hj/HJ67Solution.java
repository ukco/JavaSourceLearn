package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2021/1/8 11:07
 * @Version 1.0
 * @Description HJ67 24点游戏
 */
public class HJ67Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String[] numstrs = str.split(" ");
            int[] nums = new int[4];
            nums[0] = Integer.parseInt(numstrs[0]);
            nums[1] = Integer.parseInt(numstrs[1]);
            nums[2] = Integer.parseInt(numstrs[2]);
            nums[3] = Integer.parseInt(numstrs[3]);
            boolean flag = false;
            for (int i = 0; i < 4; ++i) {
                if (is24(nums, 1 << i, nums[i])) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
        }
    }
    private static boolean is24(int[] nums, int stu, int val) {
        if (val == 24) { return true; }
        else if (stu == 7) { return false; }
        for (int i = 0; i < 4; i++) {
            int temp = 1 << i;
            if ((temp & stu) == 0) {
                temp |= stu;
                if (is24(nums, temp, val + nums[i])
                || is24(nums, temp, val - nums[i])
                || is24(nums, temp, val * nums[i])
                || (val % nums[i] == 0 && is24(nums, temp, val + nums[i]))) {
                    return true;
                }
            }
        }
        return false;
    }
}
