package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2020/11/27 14:25
 * @Version 1.0
 * @Description HJ19
 */
public class HJ19Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Map<String, Integer> data = new LinkedHashMap<String, Integer>();
        while ((str = bf.readLine()) != null) {
            int idx1 = str.lastIndexOf(" ");
            int idx2 = str.lastIndexOf("\\");
            String key = (idx1 - idx2) > 16 ? str.substring(idx1 - 16) : str.substring(idx2 + 1);
            data.put(key, data.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (String key: data.keySet()) {
            count++;
            if (count > (data.size() - 8)) {
                System.out.println(key + " " + data.get(key));
            }
        }
    }
}
