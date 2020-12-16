package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/16 10:17
 * @Version 1.0
 * @Description HJ39
 */
public class HJ39Solution {
    public static void main (String[] args) throws IOException {
        String[] numstr = new String[]{null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] teens = new String[]{null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] points = new String[]{"", "thousand", "million", "billion"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            char[] arr = str.toCharArray();
            int len = arr.length;
            StringBuilder sb = new StringBuilder();
            boolean andflag = false;
            for(int i = (len - 1) / 3; i >= 0; i--) {
                int m = len - 1 - i * 3;
                int h = m < 2 ? 0 : (arr[m - 2] - '0');
                int t = (m < 1 ? 0 : ((arr[m - 1] - '0') * 10)) + arr[m] - '0';
                if(h == 0 && t == 0) {
                    continue;
                }
                if(t == 0 && sb.length() > 0) {
                    sb.append(" and");
                }
                if(h > 0) {
                    sb.append(' ').append(numstr[h]).append(" hundred");
                    if(t > 0)
                        sb.append(" and");
                }
                if(t > 20) {
                    sb.append(' ').append(teens[t / 10]);
                    if(t % 10 > 0)
                        sb.append(' ').append(numstr[t % 10]);
                } else if (t > 0) {
                    sb.append(' ').append(numstr[t]);
                }
                sb.append(' ').append(points[i]);
            }
            sb.deleteCharAt(0);
            System.out.println(sb.toString());
        }
    }
}
