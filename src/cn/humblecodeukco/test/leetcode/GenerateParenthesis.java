package cn.humblecodeukco.test.leetcode;

import com.sun.tools.javac.code.Attribute;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/13 11:23
 * @Version 1.0
 * @Description 22
 */
public class GenerateParenthesis {
    /**
     * 暴力解法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) { result.add(new String(current)); }
        }
        else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }
    private boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') { ++balance; }
            else { --balance; }
            if (balance < 0) { return false; }
        }
        return balance == 0;
    }

    /**
     * 回溯法
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 按括号序列的长度递归
     * @param n
     * @return
     */
    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n) {
        if (cache[n] != null) { return cache[n]; }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) { ans.add(""); }
        else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) { ans.add("(" + left + ")" + right); }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
    public List<String> generateParenthesis3(int n ) {
        return generate(n);
    }
}
