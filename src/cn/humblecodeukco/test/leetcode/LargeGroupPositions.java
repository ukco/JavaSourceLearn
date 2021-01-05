package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2021/1/5 10:06
 * @Version 1.0
 * @Description 830. 较大分组的位置
 */
public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) { return res; }

        int n = s.length();
        for (int i = 0; i < n - 1;) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) { ++j; }
            if (j - i >= 3) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j - 1);
                res.add(tmp);
            }
            i = j;
        }
        return res;
    }
}
