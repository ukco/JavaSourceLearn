package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lyr
 * @Date 2021/1/7 13:07
 * @Version 1.0
 * @Description HJ66 配置文件恢复
 */
public class HJ66Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> HMp = new HashMap<>();
        HMp.put("reset", "reset what");
        HMp.put("reset board", "board fault");
        HMp.put("board add", "where to add");
        HMp.put("board delete", "no board at all");
        HMp.put("reboot backplane", "impossible");
        HMp.put("backplane abort", "install first");
        String str;
        while ((str = read.readLine()) != null) {
            System.out.println(HMp.getOrDefault(str, "unknown command"));
        }
    }
}
