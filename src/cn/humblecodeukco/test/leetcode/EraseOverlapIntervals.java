package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lyr
 * @Date 2020/12/31 10:47
 * @Version 1.0
 * @Description 435. 无重叠区间
 */
public class EraseOverlapIntervals {
    /**
     * 动态规划
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) { return 0; }

        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        /*Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);*/
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) { f[i] = Math.max(f[i], f[j] + 1); }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    /**
     * 贪心算法
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) { return 0; }

        Arrays.sort(intervals, Comparator.comparing(interval -> interval[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
