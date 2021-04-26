package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2021/4/26 9:45
 * @Version 1.0
 * @Description 1011. 在D天内送达包裹的能力
 */
public class ShipWithinDays {
    /**
     * 二分查找转化为判定问题
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找的左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need为需要运送的天数
            // cur为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) { right = mid; }
            else { left = mid + 1; }
        }
        return left;
    }
}
