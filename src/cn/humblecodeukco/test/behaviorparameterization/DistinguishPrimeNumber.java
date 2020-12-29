package cn.humblecodeukco.test.behaviorparameterization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @Author lyr
 * @Date 2020/12/27 21:12
 * @Version 1.0
 * @Description 将数字分为质数和非质数
 */
public class DistinguishPrimeNumber {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> map = new DistinguishPrimeNumber().partitionPrimesWithCustomCollector(50);
        List<Integer> primeList = map.get(true);
        for (Integer item : primeList) { System.out.println(item); }
        System.out.println("=========================================");
        List<Integer> unprimeList = map.get(false);
        for (Integer item : unprimeList) { System.out.println(item); }
    }

    public boolean isPrime(int candidate) {
        // 产生一个自然数范围，从2开始，直至但不包括待测数
        // 如果待测数字不能被流中任何数字整除则返回true
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    /**
     * 优化
     * @param candidate
     * @return
     */
    public boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime2(candidate)));
    }

    /**
     * 自定义Collector进行筛选
     * @param n
     * @return
     */
    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    /**
     * 使用collect方法的重载版本实现自定义收集器
     * @param n
     * @return
     */
    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector2(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        // 供应源
                        () -> new HashMap<Boolean, List<Integer>>() {
                            {
                                put(true, new ArrayList<>());
                                put(false, new ArrayList<>());
                            }
                        },
                        // 累加器
                        (acc, candidate) -> {
                            acc.get(PrimeNumbersCollector.isPrime(acc.get(true), candidate)).add(candidate);
                        },
                        // 组合器
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });
    }
}
