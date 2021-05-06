package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/5/6 9:45
 * @Version 1.0
 * @Description 1720. 解码异或后的数组
 */
public class Decode {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res = new int[n + 1];
        res[0] = first;
        for (int i = 1; i < n + 1; ++i) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
