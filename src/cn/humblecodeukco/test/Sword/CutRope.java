package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/15 14:21
 * @Version 1.0
 * @Description JZ67, 14
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(new CutRopeSolution().cutRope(10));
    }
}

// 动态规划
//class CutRopeSolution {
//    public int cutRope(int target) {
//        if (target < 2) return 0;
//        if (target == 2) return 1;
//        if (target == 3) return 2; // 注意
//
//        int[] products = new int[target + 1];
//        products[0] = 0;
//        products[1] = 1;
//        products[2] = 2;
//        products[3] = 3; // 注意
//        int max;
//        for (int i = 4; i <= target; ++i) {
//            max = 0;
//            for (int j = 1; j <= i / 2; ++j) {
//                int product = products[j] * products[i - j];
//                if (max < product) max = product;
//            }
//            products[i] = max;
//        }
//        max = products[target];
//        return max;
//    }
//}

class CutRopeSolution {
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        // 尽可能多的剪去长度为3的绳子段
        int timesOf3 = target / 3;
        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        // 此时更好的方法是把绳子剪成长度为2的两段，因为 2 * 2 > 3 * 1
        if (target - timesOf3 * 3 == 1) timesOf3 -= 1;
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}