package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/9/26 20:34
 * @Version 1.0
 * @Description 5
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstringSolution longestPalindromicSubstringSolution = new LongestPalindromicSubstringSolution();
        System.out.println(longestPalindromicSubstringSolution.longestPalindrome("ababc"));
    }
}

// 暴力解法
// 时间复杂度：O(n^3)
// 空间复杂度：O(1)
//class LongestPalindromicSubstringSolution {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) return s;
//
//        // 截取子串会带来一定的性能消耗，所以一个等价的做法是只记录子串的
//        // 起始下标和长度，在最后输出的时候再做截取
//        int maxLen = 1;
//        int begin = 0;
//        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组，这一步非必需
//        char[] charArray = s.toCharArray();
//
//        // 枚举所有长度严格大于1的子串charArray[i...j]
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLen && validPalindrome(charArray, i, j)) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//    /**
//     * 验证子串 s[left...right]是否为回文串
//     * @param charArray
//     * @param left
//     * @param right
//     * @return
//     */
//    private boolean validPalindrome(char[] charArray, int left, int right) {
//        while (left < right) {
//            if (charArray[left] != charArray[right]) return false;
//            ++left;
//            --right;
//        }
//        return true;
//    }
//}

// 中心扩散法
// 枚举所有可能的回文子串的中心位置；
// 中心位置可能是一个字符，也有可能是两个相邻的字符
// 记录最长回文子文串的相关变量
// 时间复杂度：O(n^2)，枚举中心位置的个数是2(n-1)，每一次向两边扩散检测是否是回文
// 空间复杂度：O(1)
//class LongestPalindromicSubstringSolution {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) return s;
//
//        int maxLen = 1;
//        int begin = 0;
//
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < len - 1; i++) {
//            int oddLen = expandAroundCenter(charArray, i, i);
//            int evenLen = expandAroundCenter(charArray, i, i + 1);
//
//            int curMaxLen = Math.max(oddLen, evenLen);
//            if (curMaxLen > maxLen) {
//                maxLen = curMaxLen;
//                begin = i - (maxLen - 1) / 2;
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//    /**
//     *
//     * @param charArray 原始字符串的字符数组
//     * @param left 起始左边界 （可以取到）
//     * @param right 起始右边界 （可以取到）
//     * @return 回文串的长度
//     */
//    private int expandAroundCenter(char[] charArray, int left, int right) {
//        // 当 left = right的时候，回文中心是一个字符，回文串的长度是奇数
//        // 当 right = left + 1的时候，此时回文中心两个字符，回文串的长度是偶数
//        int len = charArray.length;
//        int i = left;
//        int j = right;
//        while (i >= 0 && j < len) {
//            if (charArray[i] == charArray[j]) {
//                --i;
//                ++j;
//            } else break;
//        }
//        // 跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)
//        // 回文串的长度是 j - i + 1 - 2 = j - i - 1
//        return j - i - 1;
//    }
//}

// 动态规划
// 一个回文去掉两头以后，剩下的部分依然是回文
//  - 状态：dp[i][j] 表示子串s[i...j]是否为回文子串
//  - 得到状态转移方程：dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
//   边界条件：j - 1 - (i + 1) + 1 < 2, 整理得 j - i < 3 即 j - i + 1 < 4
//  s[i...j]长度为2或者3时，不用检查子串是否回文
//  - 初始化：dp[i][j] = true
//  - 输出：在得到一个状态的值为true的时候，记录其实位置和长度，填表完成以后再截取
//   由于dp[i][j]参考它左下方的值：
//   (1) 先升序填列
//   (2) 再升序填行
// 时间复杂度：O(n^2)
// 空间复杂度：O(n^2)
// 动态规划枚举的子串个数：O(n^2)，是暴力解法的优化
// 中心扩散枚举的子串个数：O(2n) = O(n)
class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) dp[i][i] = true;

        char[] charArray = s.toCharArray();
        // 注意：左下角先填
        for (int j = 1; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串s[i...j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

// Manacher 算法
// 将原始字符串进行预处理，在预处理字符串上执行动态规划和中心扩散方法
// 为了将奇、偶回文串的性质统一表示，将原始字符串进行预处理，用不在输入字符串中的字符隔开
// (预处理字符串的回文子串的长度 - 1) / 2 = 原始字符串的回文子串的长度 = 以i为中心向两边能扩散的步数
//class LongestPalindromicSubstringSolution {
//    public String longestPalindrome(String s) {
//
//    }
//}