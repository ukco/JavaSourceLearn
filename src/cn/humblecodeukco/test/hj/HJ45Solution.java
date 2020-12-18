package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/18 18:10
 * @Version 1.0
 * @Description HJ45 名字的漂亮度
 */
public class HJ45Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value;
        while ((value = reader.readLine()) != null) {
            int num = Integer.parseInt(value);
            for (int index = 0; index < num; ++index) {
                String name = reader.readLine();
                char[] nameChars = name.toCharArray();
                int[] charMaxs = new int[150];
                for (int inda = 0; inda < nameChars.length; ++inda) {
                    charMaxs[nameChars[inda]]++;
                }
                Arrays.sort(charMaxs);
                int max = 26;
                int total = 0;
                for (int indb = charMaxs.length - 1; indb >= 0; --indb) {
                    if (charMaxs[indb] == 0) { break; }
                    total = total + charMaxs[indb] * max;
                    --max;
                }
                System.out.println(total);
            }
        }
    }
}
