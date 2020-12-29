package cn.humblecodeukco.test.behaviorparameterization;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @Author lyr
 * @Date 2020/12/29 11:09
 * @Version 1.0
 * @Description 质数改进
 */
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        // 从一个有两个空List的Map开始收集过程
        return () -> new HashMap() {
            {
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }
        };
    }

    /**
     * 将已经找到的质数列表传递给isPrime方法
     * 根据isPrime方法的返回值，从Map中取质数或非质数列表，把当前的被测数加进去
     * @return
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            // 根据isPrime的结果，获取质数或非质数的列表
            // 将被测数添加到相应的列表中
            acc.get(isPrime(acc.get(true), candidate)).add(candidate);
        };
    }

    /**
     * 实际上这个收集器是不能并行使用的，因为该算法本身是顺序的。这意味着永远都不会调用combiner方法，你可以把它的实现留空。
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        // 将第二个Map合并到第一个
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map2.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    /**
     * accumulator正好是收集器的结果，用不着进一步转换，那么finisher方法就返回identity函数
     * @return
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     * 这个收集器是IDENTITY_FINISH，但即不是UNORDERED也不是CONCURRENT，因为质数是按顺序发现的
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) { return list.subList(0, i); }
            ++i;
        }
        return list;
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }
}
