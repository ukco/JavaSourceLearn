package cn.humblecodeukco.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/9/15 22:21
 * @Version 1.0
 * @Description 167
 */
// 方法1---HashMap
// 没有利用到输入数组有序的性质
// O(n)的时间复杂度，O(n)的空间复杂度
//public class TwoSumII {
//    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
//        int [] index = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
//        for(int i : index) {
//            System.out.println(i);
//        }
//    }
//}
//
//class Solution1 {
//    public int[] twoSum(int[] numbers, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i<numbers.length; i++){
//            if(map.containsKey((target-numbers[i]))) {
//                return new int[] {map.get(target-numbers[i])+1, i+1};
//            }
//            map.put(numbers[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}

// 方法2---二分查
// 时间复杂度O(nlogn)，空间复杂度O(1)
//public class TwoSumII {
//    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
//        int [] index = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
//        for(int i : index) {
//            System.out.println(i);
//        }
//    }
//}

//class Solution1 {
//    public int[] twoSum(int[] numbers, int target) {
//        //Assure input is already sorted
//        for (int i=0; i<numbers.length; i++) {
//            int j = bsearch(numbers, target-numbers[i], i+1);
//            if(j != -1) {
//                return new int[] {i+1, j+1};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    private int bsearch(int[] A, int key, int start) {
//        int low = start, high = A.length-1, mid;
//        while(low <= high) {
//            mid = (low + high) / 2;
//            if(A[mid] == key) {
//                return mid;
//            } else if (A[mid] > key) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//}


// 方法3--双指针法
// 时间复杂度O(n)，空间复杂度O(1)
public class TwoSumII {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int [] index = solution.twoSum(new int[]{2, 7, 11, 15}, 18);
        for(int i : index) {
            System.out.println(i);
        }
    }
}

class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                --right;
            } else {
                ++left;
            }
        }
        return new int[] {-1, -1};
    }
}