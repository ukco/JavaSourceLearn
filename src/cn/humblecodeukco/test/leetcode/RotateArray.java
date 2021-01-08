package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/1/8 9:37
 * @Version 1.0
 * @Description 189. 旋转数组
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; ++i) {
            int tmp = nums[n - 1];
            int j = n - 1;
            while (j > 0) {
                nums[j] = nums[j - 1];
                --j;
            }
            nums[0] = tmp;
        }
    }

    /**
     * 优化版
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
        int n = nums.length;
        // important
        k %= n;
        int[] tmp = Arrays.copyOf(nums, n);
        for (int i = k; i < n; ++i) {
            nums[i] = tmp[i - k];
        }
        for (int i = 0; i < k; ++i) {
            nums[i] = tmp[n - k + i];
        }
    }

    /**
     * 将原数组下标为 i 的元素放至新数组下标为(i+k) mod n 的位置
     * 最后将新数组拷贝至原数组即可
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr,0, nums, 0, n);
    }

    /**
     * 环状替换
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 数组翻转
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
