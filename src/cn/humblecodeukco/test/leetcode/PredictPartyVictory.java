package cn.humblecodeukco.test.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lyr
 * @Date 2020/12/11 10:35
 * @Version 1.0
 * @Description 649
 */
public class PredictPartyVictory {
    /**
     * 循环队列
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') { radiant.offer(i); }
            else { dire.offer(i); }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) { radiant.offer(radiantIndex + n); }
            else { dire.offer(direIndex + n); }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
