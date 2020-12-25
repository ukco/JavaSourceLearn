package cn.humblecodeukco.test.hj;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author lyr
 * @Date 2020/12/25 16:35
 * @Version 1.0
 * @Description HJ54. 表达式求值
 */
public class HJ54Solution {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        System.out.println(new ExprDemo().expr(in));
    }

    public static class ExprDemo {
        public char lastsign1 = 0, lastsign2 = 0;
        public int temp1 = 0, temp2 = 0;
        private static final char tempchar = 0;

        public int expr(InputStream in) throws IOException {
            int result = 0;
            char c;
            a: while ((c = (char)in.read()) != '\n') {
                switch (c) {
                    case ')' : break a;
                    case '(' :
                        temp2 = new ExprDemo().expr(in);
                        break;
                    case '+' :
                    case '-' :
                        cal1(tempchar);
                        result = cal2(c, result);
                        break;
                    case '*' :
                    case '/' :
                        cal1(c);
                        break;
                    default:
                        temp2 = temp2 * 10 + c - '0';
                        break;
                }
            }
            cal1(tempchar);
            result = cal2(tempchar, result);
            return result;
        }

        private void cal1(char c) {
            switch (lastsign2) {
                case 0 :
                    temp1 = temp2;
                    break;
                case '*' :
                    temp1 *= temp2;
                    break;
                case '/' :
                    temp1 /= temp2;
                    break;
            }
            temp2 = 0;
            lastsign2 = c;
        }

        private int cal2(char c, int result) {
            switch (lastsign1) {
                case 0 :
                    result = temp1;
                    break;
                case '-' :
                    result -= temp1;
                    break;
                case '+' :
                    result += temp1;
                    break;
            }
            temp1 = 0;
            lastsign1 = c;
            return result;
        }
    }
}
