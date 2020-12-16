package cn.humblecodeukco.test.behaviorparameterization;

/**
 * @Author lyr
 * @Date 2020/12/16 20:48
 * @Version 1.0
 * @Description
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
