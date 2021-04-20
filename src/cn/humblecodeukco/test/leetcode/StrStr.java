package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2021/4/20 10:26
 * @Version 1.0
 * @Description 28. 实现strStr()
 */
public class StrStr {
    /**
     * 暴力匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n ; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) { return i; }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) { return 0; }

        int pn = 0;
        while (pn < n - L + 1) {
            // 找到haystack中needle字符串的第一个字符
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) { ++pn; }

            // 计算最大匹配字符串
            int currLen = 0, pL = 0;
            while (pL < L && pn <n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // 如果整个needle字符串被找到了，返回初始位置
            if (currLen == L) { return pn - L; }

            // 否则，回溯
            pn = pn - currLen + 1;
        }

        return -1;
    }
}
