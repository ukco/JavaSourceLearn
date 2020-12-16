package cn.humblecodeukco.test.behaviorparameterization;

import java.io.Serializable;

/**
 * @Author lyr
 * @Date 2020/12/16 20:46
 * @Version 1.0
 * @Description
 */
public class Apple implements Serializable {
    private int weight;
    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
