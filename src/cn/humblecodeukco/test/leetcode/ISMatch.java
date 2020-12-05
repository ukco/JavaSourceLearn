package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/5 12:38
 * @Version 1.0
 * @Description 10
 */
public class ISMatch {
    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) { return false; }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) { dp[0][i + 1] = true; }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // 如果是任意元素 或者是对于元素匹配
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) { dp[i + 1][j + 1] = dp[i][j]; }
                if (p.charAt(j) == '*') {
                    // 如果前一个元素不匹配 且不为任意元素
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 版本2
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) { return false; }
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) { f[i][j] = f[i - 1][j - 1]; }
                }
            }
        }
        return f[m][n];
    }
    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) { return false; }
        if (p.charAt(j - 1) == '.') { return true; }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
