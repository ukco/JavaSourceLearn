package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/8 20:33
 * @Version 1.0
 * @Description 26
 */
public class DelArrayDuplicates {
    public static void main(String[] args) {

    }
}

//class DelArrayDuplicatesSolution {
//    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; ++j) {
//            if (nums[j] != nums[i]){
//                ++i;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }
//}

class DelArrayDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]){
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                ++i;
            }
        }
        return i + 1;
    }
}
