package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;

/**
 * @Author lyr
 * @Date 2021/4/16 9:45
 * @Version 1.0
 * @Description 87. 扰乱字符串
 */
public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) { return false; }

        boolean[][][] dp = new boolean[n][n][n + 1];
        // 初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        // 枚举区间长度 2~n
        for (int len = 2; len <= n; ++len) {
            // 枚举S中的起点位置
            for (int i = 0; i <= n - len; i++) {
                // 枚举T中的起点位置
                for (int j = 0; j <= n - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len - 1; ++k) {
                        // 第一种情况：S1->T1，S2->T2
                        if (dp[i][j][k] && dp[i +k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1->T2，S2->T1
                        // S1起点 i, T2起点 j + 前面那段长度len - k，S2起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public boolean isScramble2(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble2(s1.substring(0, i), s2.substring(0, i)) && isScramble2(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble2(s1.substring(0, i), s2.substring(n - i)) && isScramble2(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
