package cn.humblecodeukco.test.behaviorparameterization;

/**
 * @Author lyr
 * @Date 2020/12/25 20:29
 * @Version 1.0
 * @Description
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() { return this.name; }

    public String getCity() { return this.city; }

    @Override
    public String toString() { return "Trader: " + this.name + " in " + this.city; }
}
