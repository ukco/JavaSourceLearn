package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/21 20:56
 * @Version 1.0
 * @Description 191
 */
public class NumberofBits1 {
    public static void main(String[] args) {

    }
}

/*
class NumberofBits1Soultion {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            if ((n & mask) != 0) ++bits;
            mask <<= 1;
        }
        return bits;
    }
}*/

class NumberofBits1Soultion {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            ++sum;
            n &= (n - 1);
        }
        return sum;
    }
}