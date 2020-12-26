package cn.humblecodeukco.test.behaviorparameterization;

import java.util.stream.Stream;

/**
 * @Author lyr
 * @Date 2020/12/26 14:51
 * @Version 1.0
 * @Description 斐波那契元组生成
 */
public class FibonacciTriples {
    public static void main(String[] args) {
        Stream.iterate(new int[] {0,1 }, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        System.out.println("=========================");

        Stream.iterate(new int[] {0, 1}, t -> new int[] { t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
}
