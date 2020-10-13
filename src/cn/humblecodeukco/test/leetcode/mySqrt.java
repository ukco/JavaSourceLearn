package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/12 21:55
 * @Version 1.0
 * @Description 69
 */
public class mySqrt {
}

// 袖珍计算器算法
//class mySqrtSolution {
//    public int mySqrt(int x) {
//        if (x == 0) return 0;
//        int ans = (int) Math.exp(0.5 * Math.log(x));
//        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
//    }
//}

// 二分查找
class mySqrtSolution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
