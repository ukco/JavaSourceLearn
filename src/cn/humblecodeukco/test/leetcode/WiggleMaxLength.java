package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/12/12 13:06
 * @Version 1.0
 * @Description 376
 */
public class WiggleMaxLength {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) { return n; }

        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    /**
     * 优化的动态规划
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) { return n; }
        int up = 1, down = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) { up = Math.max(up, down + 1); }
            else if (nums[i] < nums[i - 1]) { down = Math.max(up + 1, down); }
        }
        return Math.max(up, down);
    }

    /**
     * 优化的动态规划
     * @param nums
     * @return
     */
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) { return n; }
        int up = 1, down = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) { up = down + 1; }
            else if (nums[i] < nums[i - 1]) { down = up + 1; }
        }
        return Math.max(up, down);
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public int wiggleMaxLength4(int[] nums) {
        int n = nums.length;
        if (n < 2) { return n; }
        int previdff = nums[1] - nums[0];
        int ret = previdff != 0 ? 2 : 1;
        for (int i = 2; i < n; ++i) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && previdff <= 0) || (diff < 0 && previdff >= 0)) {
                ret++;
                previdff = diff;
            }
        }
        return ret;
    }
}
