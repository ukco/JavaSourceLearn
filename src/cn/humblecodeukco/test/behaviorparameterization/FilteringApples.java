package cn.humblecodeukco.test.behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/12/16 20:49
 * @Version 1.0
 * @Description
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"), new Apple(120, "red"));
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        System.out.println("result 1:");
        for (Apple apple: heavyApples) { System.out.println(apple.getWeight() + " " + apple.getColor()); }
        System.out.println("result 2");
        for (Apple apple: greenApples) { System.out.println(apple.getWeight() + " " + apple.getColor()); }
    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) { result.add(apple); }
        }
        return result;
    }
}
