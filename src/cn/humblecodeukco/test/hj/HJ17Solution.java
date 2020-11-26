package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/11/26 9:21
 * @Version 1.0
 * @Description HJ17
 */
public class HJ17Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int x = 0;
        int y = 0;
        while ((str = reader.readLine()) != null) {
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                char[] chars = split[i].toCharArray();
                int length = 0;
                if (chars.length > 3) { continue; }
                for (int j = 1; j < chars.length; j++) {
                    if (chars[j] >= '0' && chars[j] <= '9') {
                        length = length * 10 + chars[j] - '0';
                    } else {
                        length = 0;
                        break;
                    }
                }
                switch (chars[0]) {
                    case 'A' :
                        x -= length;
                        break;
                    case 'S' :
                        y -= length;
                        break;
                    case 'W' :
                        y += length;
                        break;
                    case 'D' :
                        x += length;
                    default:
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
