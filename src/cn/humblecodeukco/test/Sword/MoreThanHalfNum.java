package cn.humblecodeukco.test.Sword;

import java.util.Random;

/**
 * @Author lyr
 * @Date 2020/10/19 15:04
 * @Version 1.0
 * @Description
 */
//public class MoreThanHalfNum {
//    public int MoreThanHalfNum_Solution(int[] array) {
//        if (array == null || array.length <= 0) return 0;
//
//        int length = array.length;
//        int middle = length >> 1;
//        int start = 0, end = length - 1;
//        int index = Partition(array, length, start, end);
//        while (index != middle) {
//            if (index > middle) {
//                end = index - 1;
//                index = Partition(array, length, start, end);
//            } else {
//                start = index + 1;
//                index = Partition(array, length, start, end);
//            }
//        }
//
//        int result = array[middle];
//        if (!CheckMoreThanHalf(array, length, result)) result = 0;
//        return result;
//    }
//
//    public int Partition(int[] data, int length, int start, int end) {
//        if (data == null || length <= 0 || start < 0 || end >= length)
//            throw new IllegalArgumentException("Invalid Parameters");
//
//        // 生成一个在 start 和 end 之间的随机数
//        Random random = new Random();
//        int index = random.nextInt(end - start + 1) + start;
//
//        int tmp = data[end];
//        data[end] = data[index];
//        data[index] = tmp;
//
//        int small = start - 1;
//        for (index = start; index < end; ++index) {
//            if (data[index] < data[end]) {
//                ++small;
//                if (small != index) {
//                    tmp = data[small];
//                    data[small] = data[index];
//                    data[index] = tmp;
//                }
//            }
//        }
//        ++small;
//
//        tmp = data[end];
//        data[end] = data[small];
//        data[small] = tmp;
//
//        return small;
//    }
//
//    boolean g_bInputInvalid = false;
//
//    boolean CheckInvalidArray(int[] numbers, int length) {
//        g_bInputInvalid = false;
//        if (numbers == null || length <= 0) g_bInputInvalid = true;
//        return g_bInputInvalid;
//    }
//
//    boolean CheckMoreThanHalf(int[] numbers, int length, int number) {
//        int times = 0;
//        for (int i = 0; i < length; ++i) {
//            if (numbers[i] == number) times++;
//        }
//        boolean isMoreThanHalf = true;
//        if (times * 2 <= length){
//            g_bInputInvalid = true;
//            isMoreThanHalf = false;
//        }
//        return isMoreThanHalf;
//    }
//}

class Test {
    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[] {1,2,3,4,5,6,7}));
    }
}

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) return 0;
        int length = array.length;
        int result = array[0];
        int times = 1;
        for (int i = 0; i < length; ++i) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) ++times;
            else --times;
        }
        if (!CheckMoreThanHalf(array, length, result)) result = 0;
        return result;
    }

    boolean g_bInputInvalid = false;
    boolean CheckMoreThanHalf(int[] numbers, int length, int number) {
        int times = 0;
        for (int i = 0; i < length; ++i) {
            if (numbers[i] == number) times++;
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= length){
            g_bInputInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
}