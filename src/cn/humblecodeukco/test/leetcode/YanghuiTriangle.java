package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/6 13:20
 * @Version 1.0
 * @Description 118
 */
public class YanghuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) { row.add(1); }
                else { row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j)); }
            }
            ret.add(row);
        }
        return ret;
    }
}
