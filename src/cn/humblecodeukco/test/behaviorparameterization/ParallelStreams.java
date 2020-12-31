package cn.humblecodeukco.test.behaviorparameterization;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author lyr
 * @Date 2020/12/29 15:59
 * @Version 1.0
 * @Description 求和的三种方法
 */
public class ParallelStreams {
    /**
     * 顺序流
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; ++i) { result += i; }
        return result;
    }

    /**
     * 并行流
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    /**
     * 采用不用拆箱的方法 rangeClosed，且可以正确的并行处理
     * @param n
     * @return
     */
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /**
     * 并行流
     * @param n
     * @return
     */
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
}
