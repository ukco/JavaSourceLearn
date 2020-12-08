package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/8 11:01
 * @Version 1.0
 * @Description 842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {
    /**
     * 回溯 + 剪枝
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }
    private boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) { return list.size() >= 3; }
        long currLong = 0;
        for (int i = index; i < length; ++i) {
            // 如果当前拼接的字符串是以0开头且接下来继续拼接的话长度会大于1，不能继续拼接。
            if (i > index && S.charAt(index) == '0') { break; }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) { break; }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) { continue; }
                else if (curr > sum) { break; }
            }
            list.add(curr);
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) { return true; }
            else { list.remove(list.size() - 1); }
        }
        return false;
    }
}
