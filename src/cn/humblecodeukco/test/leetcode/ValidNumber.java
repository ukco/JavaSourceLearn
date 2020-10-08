package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/9/24 18:43
 * @Version 1.0
 * @Description 65
 */
public class ValidNumber {
    public static void main(String[] args) {
        ValidNumberSolution validNumberSolution = new ValidNumberSolution();
        System.out.println(validNumberSolution.isNumber("345"));
    }
}

class ValidNumberSolution {
    /**
     * 确定有限状态机(DFA)。构造一个DFA并实现，构造方法可以先写正则表达式，然后转为DFA。
     * DFA作为确定的有限状态机，比NFA更加实用，因为对于每一个状态接收的下一个字符，DFA
     * 能确定唯一一条转换路径，所以使用简单的表驱动的一些方法就可以实现，并且只需要读入
     * 一遍输入流，比起NFA需要回读在速度上会有所提升
     * https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
     * @param s 接收的字符串
     * @return
     */
    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int [][] transfer = new int[][] {{0, 1, 6, 2, -1},
                                         {-1, -1, 6, 2, -1},
                                         {-1, -1, 3, -1, -1},
                                         {8, -1, 3, -1, 4},
                                         {-1, 7, 5, -1, -1},
                                         {8, -1, 5, -1, -1},
                                         {8, -1, 6, 3, 4},
                                         {-1, -1, 5, -1, -1},
                                         {8, -1, -1, -1, -1}};
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) >0;
    }

    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if (c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

}