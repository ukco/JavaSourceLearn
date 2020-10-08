package cn.humblecodeukco.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2020/9/8 14:20
 * @Version 1.0
 * @Description
 */
public class TripleTest {
    public static void main(String[] args) {
        List<Triple<String, String, String>> tripleList = new ArrayList<>();
        Triple<String, String, String> triple1 = new Triple<>("椭圆", "方程", "椭圆的方程关系");
        Triple<String, String, String> triple2 = new Triple<>("点", "直线", "点在直线上的关系");
        Triple<String, String, String> triple3 = new Triple<>("直线","直线", "直线的相交关系");
        tripleList.add(triple1);
        tripleList.add(triple2);
        tripleList.add(triple3);
        for(int i = 0; i < tripleList.size(); i++){
            System.out.println(tripleList.get(i).toString());
        }
    }
}

class Triple<T, U, V>{
    private final T first;
    private final U second;
    private final V third;

    public Triple(T first, U second, V third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
    public V getThird() { return third; }

    @Override
    public String toString(){
        return "(" + this.first + " " + this.second + " " + this.third + ")";
    }
}