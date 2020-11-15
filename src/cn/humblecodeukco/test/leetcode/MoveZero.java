package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/15 21:28
 * @Version 1.0
 * @Description 283
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] array = new int[] {2, 1};
        MoveZeroSolution moveZeroSolution = new MoveZeroSolution();
        moveZeroSolution.moveZeroes3(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
}

class MoveZeroSolution {
    /**
     * 两次遍历
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) return ;
        // 第一次遍历的时候，j 指针记录非0的个数，只要是非0的统统赋值给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        // 非0元素统计完了，剩下的都是0了
        // 所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) nums[i] = 0;
    }

    /**
     * 一次遍历
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) return ;
        // 两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 当前元素 != 0 ，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    /**
     * 一次遍历优化，避免初始时 i==j 时的交换
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}