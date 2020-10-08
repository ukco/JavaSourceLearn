package cn.humblecodeukco.test.leetcode;

import sun.util.resources.cldr.en.CurrencyNames_en_TT;

/**
 * @Author lyr
 * @Date 2020/9/18 12:42
 * @Version 1.0
 * @Description 28
 */
public class ImplementstrStr {
    public static void main(String[] args) {
        strSolution strsolution = new strSolution();
        System.out.println(strsolution.strStr("hello", "ll"));
    }
}

//class strSolution {
//    public int strStr(String haystack, String needle) {
//        for(int i=0; ; i++) {
//            for(int j=0; ; j++) {
//                if (j==needle.length()) return i;  //needle空返回0
//                if (i+j==haystack.length()) return -1;
//                if (needle.charAt(j) != haystack.charAt(i+j)) break;
//            }
//        }
//    }
//}

// 方法一：子串逐一比较-线性时间复杂度
// 最直接的方法-沿着字符串逐步移动滑动窗口，将窗口内的子串与needle字符串比较
// 时间复杂度O((N-L)L)。内循环中比较字符串的复杂度为L，总共需要比较(N-L)次。
// 空间复杂度O(1)
//class strSolution {
//    public int strStr(String haystack, String needle) {
//        int L = needle.length(), n = haystack.length();
//        for (int start = 0; start < n - L + 1; ++start) {
//            if (haystack.substring(start, start + L).equals(needle)) {
//                return start;
//            }
//        }
//        return -1;
//    }
//}

// 方法二：双指针-线性时间复杂度
// 上一个方法的缺陷是会将haystack所有长度为L的子串都与needle字符串比较，实际上是不需要这么做的。
// 首先，只有子串的第一个字符跟needle字符串第一个字符相同的时候才需要比较
// 其次，可以一个字符一个字符比较，一旦不匹配了就立刻终止
// 时间复杂度：最坏情况时间复杂度为O((N-L)L)，最优时间复杂度为O(N)
// 空间复杂度：O(1)
//class strSolution {
//    public int strStr(String haystack, String needle) {
//        int L = needle.length(), n = haystack.length();
//        if (L == 0) return 0;
//
//        int pn = 0;
//        while (pn < n - L + 1) {
//            // 找到haystack中needle字符串的第一个字符
//            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
//
//            // 计算最大匹配字符串
//            int currLen = 0, pL = 0;
//            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
//                ++pn;
//                ++pL;
//                ++currLen;
//            }
//
//            // 如果整个needle字符串被找到了，返回初始位置
//            if (currLen == L) return pn - L;
//
//            // 否则，回溯
//            pn = pn -currLen + 1;
//        }
//        return -1;
//    }
//}

// 方法三：Rabin Karp-常数复杂度
// 有一种最坏时间复杂度也为O(N)的算法。思路是这样的，先生成窗口内子串的哈希码，然后在跟needle
// 字符串的哈希码做比较。有一个问题需要解决，如何在常数时间生成子串的哈希码？
// https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/
// 时间复杂度：O(N)，计算needle字符串的哈希值需要O(L)时间，之后需要执行(N-L)次循环，每次循环的计算复杂度为常数
// 空间复杂度：O(1)
class strSolution {
    /** 算法描述：
     *    计算子字符串haystack.substring(0, L)和needle.substring(0, L)的哈希值
     *    从起始位置开始遍历：从第一个字符遍历到第N-L个字符
     *      根据前一个哈希值计算滚动哈希
     *      如果子字符串哈希值与needle字符串哈希值相等，返回滑动窗口起始位置
     *    返回-1，这时候haystack字符串中不存在needle字符串
     */
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often: a^L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;
        //aL = (long)Math.pow(a, L) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start -1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            // ref_h has been computed
            if (h == ref_h) return start;
        }
        return -1;
    }

    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }
}

// 方法四：KMP算法