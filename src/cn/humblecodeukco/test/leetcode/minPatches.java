package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/29 9:40
 * @Version 1.0
 * @Description 330. 按要求补齐数组
 */
public class minPatches {
    /**
     * 贪心
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
         int patches = 0;
         long x = 1;
         int length = nums.length, index = 0;
         while (x <= n) {
             if (index < length && nums[index] <= x) {
                 x += nums[index];
                 ++index;
             } else {
                 x *= 2;
                 ++patches;
             }
         }
         return patches;
    }

    /**
     * 核心逻辑：[0,x) 的若干个数加上 k，可扩大值域至 [0,x+k)，注意 k∈[0,x]。
     * 将 k 视为 nums已有的数 或者 要插入的数
     * 根据题意，nums 必须有 1
     * 显然从 [0,1) 开始模拟扩展，一般地，我们取 k 最大，也就是 k = x
     * 假设 nums 空，我们这样模拟 [0,1) -> [0,2) -> [0,4) -> [0,8) ----> [0,y)，直到 y > n
     * 因此当 nums(i) ∈ [0,y] 时，可取之为 k 并扩大值域， 否则视为插入一个数 y。
     * @param nums
     * @param n
     * @return
     */
    public int minPatches2(int[] nums, int n) {
        long maxi = 1;
        int i = 0, res = 0;
        while (maxi <= n) {
            if (i < nums.length && nums[i] <= maxi) { maxi += nums[i++]; }
            else {
                maxi += maxi;
                ++res;
            }
        }
        return res;
    }

    /**
     * 贪心思想，每次加入nums的数都要在满足条件的前提下尽可能的大以覆盖更大的范围。
     * 因为是从小到大分析，因此每次有数加入nums一定是因为nums的总和小于这个数从而无法表示。
     * 如果当前分析到k，则[1,k]一定可以全部由nums中的某些数之和表示。
     * https://leetcode-cn.com/problems/patching-array/solution/tan-xin-fu-gai-wen-ti-xiang-xi-jie-xi-by-dwux/
     * @param nums
     * @param n
     * @return
     */
    public int minPatches3(int[] nums, int n) {
        int count = 0, index = 0;
        // 缺失的数
        long curr = 1;
        while (curr <= n) {
            if (index >= nums.length || nums[index] > curr) {
                ++count;
                curr *= 2;
            } else { curr += nums[index++]; }
        }
        return count;
    }

    public int minPatches4(int[] nums, int n) {
        // 累加的综合
        long total = 1;
        // 需要补充的数字个数
        int count = 0;
        // 访问的数组下标索引
        int index = 0;
        while (total <= n) {
            if (index < nums.length && nums[index] <= total) {
                // 如果数组能组成的数字范围是[1,total]，那么加上nums[index]
                // 就变成了[1,total]U[nums[index],total+nums[index]]
                // 结果就是[1,total+nums[index]]
                total += nums[index++];
            } else {
                // 添加一个新数字，并且count加1
                total <<= 1;
                ++count;
            }
        }
        return count;
    }
}
