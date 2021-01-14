package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2021/1/14 13:17
 * @Version 1.0
 * @Description 1018. 可被5整除的二进制前缀
 */
public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;
    }
}
