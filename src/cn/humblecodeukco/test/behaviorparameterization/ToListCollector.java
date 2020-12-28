package cn.humblecodeukco.test.behaviorparameterization;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author lyr
 * @Date 2020/12/28 21:52
 * @Version 1.0
 * @Description 为Collector接口提供自己的实现，从而自由地创建自定义规约操作
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    /**
     * 创建集合操作的起始点
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 累积遍历过的项目，原位修改累加器
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 恒等函数
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 修改第一个累加器，将其与第二个累加器的内容合并
     * 返回修改后的第一个累加器
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 为收集器添加IDENTITY_FINISH和CONCURRENT标志
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
