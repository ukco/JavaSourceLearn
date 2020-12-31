package cn.humblecodeukco.test.behaviorparameterization;

import java.util.function.Function;

/**
 * @Author lyr
 * @Date 2020/12/29 15:28
 * @Version 1.0
 * @Description 比较三种不同的方式（迭代式、顺序归纳、并行归纳）求和的效率
 */
public class SumTest {
    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; ++i) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) { fastest = duration; }
        }
        return fastest;
    }

    public static void main(String[] args) {
        SumTest sumTest = new SumTest();
        System.out.println("Sequential sum done in: " + sumTest.measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + "msecs");
        System.out.println("Iterative sum done in: " + sumTest.measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + "msecs");
        System.out.println("Parallel sum done in: " + sumTest.measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + "msecs");
        System.out.println("Sequential RangeClosed sum done in: " + sumTest.measureSumPerf(ParallelStreams::rangedSum, 10_000_000) + "msecs");
        System.out.println("Parallel RangedClosed sum done in: " + sumTest.measureSumPerf(ParallelStreams::parallelRangedSum, 10_000_000) + "msecs");
        System.out.println("ForkJoin sum done in: " + sumTest.measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + "msecs");
    }
}
