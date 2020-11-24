package cn.humblecodeukco.test.hj;

import java.io.InputStream;

/**
 * @Author lyr
 * @Date 2020/11/24 9:19
 * @Version 1.0
 * @Description HJ15
 */
public class HJ15Solution {
    public static void main(String[] args) throws Exception {
        InputStream stream = System.in;
        int l;
        byte[] bytes = new byte[1024];
        while ((l = stream.read(bytes)) > 0) {
            String numStr = new String(bytes, 0, l - 1);
            int num = Integer.parseInt(numStr);
            char[] numChars = Integer.toBinaryString(num).toCharArray();
            int countNum = 0;
            for (int i = 0; i < numChars.length; i++) {
                if (numChars[i] == '1') { countNum += 1; }
            }
            System.out.println(countNum);
        }
    }
}
