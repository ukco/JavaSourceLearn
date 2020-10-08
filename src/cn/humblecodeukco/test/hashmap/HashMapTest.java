package cn.humblecodeukco.test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/9/8 14:20
 * @Version 1.0
 * @Description
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Double> hashmap = new HashMap<>();

        hashmap.put("k1", 0.1);
        hashmap.put("k2", 0.2);
        hashmap.put("k3", 0.3);
        hashmap.put("k4", 0.4);
    }
}
