package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/9 18:18
 * @Version 1.0
 * @Description 11
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWaterSolution().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}

class ContainerWithMostWaterSolution {
    /**
     * 暴力循环
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) ++l;
            else --r;
        }
        return ans;
    }
}
