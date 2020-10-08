package cn.humblecodeukco.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/10/6 14:06
 * @Version 1.0
 * @Description 15
 */
public class SumOfTree {
    public static void main(String[] args) {

    }
}

// 排序 + 双指针
// 时间复杂度：O(N^2)，其中 N 是数组 nums 的长度。
// 空间复杂度：O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为 O(logN)。然而我们修改了输入的
// 数组 nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了 nums 的副本并进行排序，空
// 间复杂度为 O(N)。
class SumOfTreeSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // 排序
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) --third;
                // 如果指针重合，随着b后续的增加
                // 就不会有满足a+b+c=0并且b<c的c了，可以退出循环
                if (second == third) break;

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
