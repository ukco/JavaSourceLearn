package cn.humblecodeukco.test.leetcode;

import java.util.*;

/**
 * @Author lyr
 * @Date 2021/1/2 14:12
 * @Version 1.0
 * @Description 239. 滑动窗口的最大值
 */
public class MaxSlidingWindow {
    /**
     * 超出时间限制
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) { return list.stream().mapToInt(Integer::intValue).toArray(); }
        Queue<Integer> queue = new LinkedList<>();
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) {
            queue.offer(nums[i]);
            if (nums[i] > Max) { Max = nums[i]; }
        }
        list.add(Max);
        for (int i = k; i < nums.length; ++i) {
            queue.poll();
            queue.offer(nums[i]);
            list.add(findQueueMax(queue, k));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private int findQueueMax(Queue<Integer> queue, int k) {
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) {
            int tmp = queue.poll();
            if (Max < tmp) { Max = tmp; }
            queue.offer(tmp);
        }
        return Max;
    }

    /**
     * 优先队列
     * 在优先队列中存储二元组 (num,index)，表示元素 num 在数组中的下标为 index。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 对于下标的排列不论是递增还是递减都本题都没有影响
        PriorityQueue<int[]> pq = new PriorityQueue<>
                ((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair1[1] - pair2[1]);
        for (int i = 0; i < k; ++i) { pq.offer(new int[] {nums[i], i}); }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[] {nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /**
     * 单调队列（双端队列）
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) { deque.pollLast(); }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) { deque.pollLast(); }
            deque.offerLast(i);
            // 判断当前队列中队首的值是否有效
            while (deque.peekFirst() <= i - k) { deque.pollFirst(); }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    /**
     * 分块 + 预处理
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) { prefixMax[i] = nums[i]; }
            else { prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]); }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) { suffixMax[i] = nums[i]; }
            else { suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]); }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k ; i++) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = new MaxSlidingWindow().maxSlidingWindow2(new int[] {1,1,2,3,-1,3,2,2,6,7}, 3);
    }
}
