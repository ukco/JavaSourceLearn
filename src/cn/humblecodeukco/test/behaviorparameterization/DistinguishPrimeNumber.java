package cn.humblecodeukco.test.behaviorparameterization;

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
}
