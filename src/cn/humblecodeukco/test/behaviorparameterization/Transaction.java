package cn.humblecodeukco.test.behaviorparameterization;

/**
 * @Author lyr
 * @Date 2020/12/25 20:32
 * @Version 1.0
 * @Description
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() { return this.trader; }

    public int getYear() { return this.year; }

    public int getValue() { return this.value; }

    @Override
    public String toString() {
        return "{" + this.trader + ", " + "year: " +
                this.year + ", " + "value: " + this.value + "}";
    }
}
