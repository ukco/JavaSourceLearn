package cn.humblecodeukco.test.behaviorparameterization;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author lyr
 * @Date 2020/12/26 14:20
 * @Version 1.0
 * @Description 数值流应用：勾股数
 */
public class Pythagorean {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                 .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                 .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
                );

        // 优化
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                 .mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
                                 .filter(t -> t[2] % 1 == 0));

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        System.out.println("=============================");

        pythagoreanTriples2.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
