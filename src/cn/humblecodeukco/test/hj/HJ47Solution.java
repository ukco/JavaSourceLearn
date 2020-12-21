package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 2020/12/21 10:30
 * @Version 1.0
 * @Description HJ47 线性插值
 */
public class HJ47Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int total = Integer.parseInt(line.split(" ")[0]);
            if (total > 0) {
                StringBuilder sb = new StringBuilder();
                String thisLine = reader.readLine();
                String[] elements = thisLine.split(" ");
                int num = Integer.parseInt(elements[0]);
                int value = Integer.parseInt(elements[1]);

                int preNum = num;
                int preValue = value;
                sb.append(thisLine).append("\n");
                for (int i = 1; i < total; ++i) {
                    thisLine = reader.readLine();
                    elements = thisLine.split(" ");
                    num = Integer.parseInt(elements[0]);
                    value = Integer.parseInt(elements[1]);
                    if (num == preNum) { continue; }
                    for (int j = preNum + 1; j < num; ++j) {
                        sb.append(j).append(" ").
                                append(preValue + (value - preValue) / (num - preNum) * (j - preNum)).append("\n");
                    }
                    preNum = num;
                    preValue = value;
                    sb.append(thisLine).append("\r\n");
                }
                System.out.print(sb.toString());
            }
        }
    }
}
