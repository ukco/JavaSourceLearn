package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/3 16:47
 * @Version 1.0
 * @Description 27. 移除元素
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{4,4,0,1,0,2}, 0));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) { return 0; }

        int originalLength = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; ++j) {
                    nums[j - 1] = nums[j];
                }
                nums[originalLength - 1] = 0;
                --originalLength;
                --i;
            }
            if (i == originalLength - 1) { break; }
        }
        return originalLength;
    }

    /**
     * 双指针
     * 保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。
     * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j]=val，
     * 我们就复制 nums[j] 到 nums[i] 并同时递增两个索引。重复这一过程，直到 j 到达数组的末尾，该数组的新长度为i。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                ++i;
            }
        }
        return i;
    }

    /**
     * 双指针--当要删除的元素很少时
     * 当我们遇到 nums[i] = val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。
     * 这实际上使数组的大小减少了 1。
     * 请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                --n;
            } else { ++i; }
        }
        return n;
    }
}