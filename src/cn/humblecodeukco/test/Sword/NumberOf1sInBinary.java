package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/6 12:46
 * @Version 1.0
 * @Description JZ11, 15
 */
public class NumberOf1sInBinary {
    public static void main(String[] args) {
        System.out.println(new NumberOf1sInBinarySolution().NumberOf1(8));
    }
}

//class NumberOf1sInBinarySolution {
//    public int NumberOf1(int n) {
//        int count = 0;
//        while (n != 0) {
//            count += n & 1;
//            n = n >> 1;
//        }
//        return count;
//    }
//}

//class NumberOf1sInBinarySolution {
//    public int NumberOf1(int n) {
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) == 1) count++;
//            flag = flag << 1;
//        }
//        return count;
//    }
//}

class NumberOf1sInBinarySolution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}