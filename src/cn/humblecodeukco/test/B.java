package cn.humblecodeukco.test;

/**
 * @Author lyr
 * @Date 2021/1/7 10:17
 * @Version 1.0
 * @Description
 */
public class B
{
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        B t = new B();
    }
}