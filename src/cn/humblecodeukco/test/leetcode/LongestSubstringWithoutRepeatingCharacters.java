package cn.humblecodeukco.test.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @Date 2020/9/25 12:29
 * @Version 1.0
 * @Description 3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringSolution longestSubstringSolution = new LongestSubstringSolution();
        System.out.println(longestSubstringSolution.lengthOfLongestSubstring("abcabcbb"));
    }
}

// 滑动窗口
// 时间复杂度：O(N)，其中N是字符串的长度。左指针和右指针分别会遍历整个字符串一次
// 空间复杂度：O(|Σ|)，其中Σ表示字符集（即字符串中可以出现的字符），|Σ|表示字符集的
// 大小。在本题中没有明确说明字符集，因此可以默认为所有ASCII码在[0, 128)内的字符，
// 即|Σ|=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有|Σ|个，因此空间
// 复杂度为O(|Σ|)
class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第i到rk个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

//class LongestSubstringSolution {
//    public int lengthOfLongestSubstring(String s) {
//        // 记录字符上一次出现的位置
//        int[] last = new int[128];
//        for(int i = 0; i < 128; i++) {
//            last[i] = -1;
//        }
//        int n = s.length();
//        int res = 0;
//        int start = 0; // 窗口开始位置
//        for (int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index] + 1);
//            res = Math.max(res, i - start + 1);
//            last[index] = i;
//        }
//        return res;
//    }
//}