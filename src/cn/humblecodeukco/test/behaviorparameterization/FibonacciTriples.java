package cn.humblecodeukco.test.behaviorparameterization;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
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

        System.out.println("=========================");

        // generate方法的使用，是有状态的流操作，在并行操作时是不安全的，避免使用
        IntSupplier fib = new IntSupplier() {
            // 记录状态
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(20).forEach(System.out::println);
    }
}
