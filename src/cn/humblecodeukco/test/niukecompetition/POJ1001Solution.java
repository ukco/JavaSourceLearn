package cn.humblecodeukco.test.niukecompetition;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author lyr
 * @Date 2020/12/9 20:30
 * @Version 1.0
 * @Description
 */
public class POJ1001Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal result = scanner.nextBigDecimal();
            int n = scanner.nextInt();

            result = result.pow(n);
            String string = result.stripTrailingZeros().toPlainString();

            if (string.startsWith("0.")) { string = string.substring(1); }
            System.out.println(string);
        }
    }
}
