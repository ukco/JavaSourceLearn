package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/2 14:32
 * @Version 1.0
 * @Description JZ51, 66
 */
public class ProductArray {
    public static void main(String[] args) {
        ProductArraySolution productArraySolution = new ProductArraySolution();
        int[] result = productArraySolution.multiply(new int[] {1, 2, 3, 4, 5, 6});
        for (int i = 0; i < result.length; ++i) {
            System.out.println(result[i]);
        }
    }
}

class ProductArraySolution {
    public int[] multiply(int[] A) {
        if (A == null || A.length < 2) return null;

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >= 0; --i) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }
}
