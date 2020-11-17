package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/11/17 12:39
 * @Version 1.0
 * @Description 406
 */
public class RebuildQueueBasedOnHeight {
}

class RebuildQueueBasedOnHeightSolution {
    /**
     * 从低到高考虑
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) return person1[0] - person2[0];
                else return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 从高到低考虑
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) return person2[0] - person1[0];
            else return person1[1] - person2[1];
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) ans.add(person[1], person);
        return ans.toArray(new int[ans.size()][]);
    }
}