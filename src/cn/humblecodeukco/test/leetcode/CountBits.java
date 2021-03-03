package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/3/3 15:59
 * @Version 1.0
 * @Description 338. 比特位技术
 */
public class CountBits {
    /**
     * 直接计算
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    /**
     * 按位与运算（&）的一个性质是：对于任意整数 x，
     * 令 x=x&(x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，
     * 则操作次数即为 x 的「一比特数」。
     * @param x
     * @return
     */
    private int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划 -- 最高有效位
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 动态规划 -- 最低有效位
     * @param num
     * @return
     */
    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    /**
     * 动态规划 -- 最低设置位
     * @param num
     * @return
     */
    public int[] countBits4(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
