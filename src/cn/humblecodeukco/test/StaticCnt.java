package cn.humblecodeukco.test;

/**
 * @Author lyr
 * @Date 2021/1/7 10:38
 * @Version 1.0
 * @Description
 */
public class StaticCnt {
    static int cnt = 6;
    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println(cnt);
    }

    static {
        cnt /= 3;
    }
}
