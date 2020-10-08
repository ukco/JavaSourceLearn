package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/4 19:20
 * @Version 1.0
 * @Description JZ8, 10题目二
 */
public class Jump {
    public static void main(String[] args) {
            System.out.println(new JumpSolution().JumpFloor(0));
    }
}

class JumpSolution {
    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}