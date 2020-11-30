package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/30 10:54
 * @Version 1.0
 * @Description 168. Excel表列名称
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 1;
            sb.append((char) ('A' + (n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(28));
    }
}
