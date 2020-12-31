package cn.humblecodeukco.test.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @Author lyr
 * @Date 2020/12/30 15:15
 * @Version 1.0
 * @Description 1046 最后一块石头的重量
 */
public class LastStoneWeight {
    /**
     * 暴力
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) { return - 1; }
        if (stones.length == 1) { return stones[0]; }

        int len = stones.length;
        while (len > 1) {
            stones = IntStream.of(stones).boxed().sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();
            if (stones[0] == stones[1]) {
                stones[0] = 0;
            } else {
                stones[0] = stones[0] - stones[1];
            }
            stones[1] = 0;
            --len;
        }
        return stones[0];
    }

    /**
     * 最大堆
     * @param stones
     * @return
     */
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) { pq.offer(stone); }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) { pq.offer(a - b); }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
