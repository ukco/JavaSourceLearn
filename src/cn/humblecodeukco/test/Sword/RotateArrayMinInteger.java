package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/9/29 10:03
 * @Version 1.0
 * @Description JZ6, 11
 */
//public class RotateArrayMinInteger {
//    public int minNumberInRotateArray(int [] array) {
//        if (array == null || array.length <= 0) throw new IllegalArgumentException("Invalid parameters");
//
//        int index1 = 0;
//        int index2 = array.length - 1;
//        // 若果把排序数组的前面的0个元素搬到最后面，即排序数组本身，这仍然是数组的一个旋转，此时，数组中的第一个数字就是最小的数字，可以直接返回
//        // 这就是把indexMid初始化为index1的原因
//        int indexMid = index1;
//        while (array[index1] >= array[index2]) {
//            if (index2 - index1 == 1) {
//                indexMid = index2;
//                break;
//            }
//
//            indexMid = (index1 + index2) / 2;
//            if (array[indexMid] >= array[index1])
//                index1 = indexMid;
//            else if (array[indexMid] <= array[index2])
//                index2 = indexMid;
//        }
//        return array[indexMid];
//    }
//}

public class RotateArrayMinInteger {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) throw new IllegalArgumentException("Invalid parameters");

        int index1 = 0;
        int index2 = array.length - 1;
        // 若果把排序数组的前面的0个元素搬到最后面，即排序数组本身，这仍然是数组的一个旋转，此时，数组中的第一个数字就是最小的数字，可以直接返回
        // 这就是把indexMid初始化为index1的原因
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            // 如果下标为index1、index2和indexMid指向的三个数字相等，则只能顺序查找
            if (array[index1] == array[index2] && array[index1] == array[indexMid])
                return MinInOrder(array, index1, index2);

            if (array[indexMid] >= array[index1])
                index1 = indexMid;
            else if (array[indexMid] <= array[index2])
                index2 = indexMid;
        }
        return array[indexMid];
    }

    public int MinInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }
}
