package cn.humblecodeukco.test.behaviorparameterization;

/**
 * @Author lyr
 * @Date 2020/12/16 20:47
 * @Version 1.0
 * @Description
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
