package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lyr
 * @Date 2020/11/23 14:43
 * @Version 1.0
 * @Description 452
 */
public class FindMinArrowShots {
    /**
     * 排序 + 贪心
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public int findMinArrowShots2(int[][] points) {
        if (points == null || points.length == 0) { return 0; }
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        // 获取排序后第一个气球右边界的位置，我们可以认为是箭射入的位置
        int last = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            // 如果箭射入的位置小于下标为i这个气球的左边位置，说明这支箭不能
            // 击爆下标为i的这个气球，需要再拿出一支箭，并且要更新这支箭射入的
            // 位置
            if (last < points[i][0]) {
                last = points[i][1];
                count++;
            }
        }
        return count;
    }
}
