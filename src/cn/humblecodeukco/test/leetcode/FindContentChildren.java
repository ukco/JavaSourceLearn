package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/25 9:36
 * @Version 1.0
 * @Description 455. 分发饼干
 */
public class FindContentChildren {
    /**
     * 初版本
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int flag = 0;
        for (int i = 0; i < g.length; ++i) {
            for (int j = flag; j < s.length; ++j) {
                if (s[j] >= g[i]) {
                    ++count;
                    flag = j + 1;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 排序 + 贪心
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; ++i, ++j) {
            while (j < numOfCookies && g[i] > s[j]) { ++j; }
            if (j < numOfCookies) { ++count; }
        }
        return count;
    }

    /**
     * 改良
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren3(int[]g, int[]s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] >= g[count]) {
                ++count;
                if (count == g.length) { break; }
            }
        }
        return count;
    }
}
