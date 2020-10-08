package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/6 12:07
 * @Version 1.0
 * @Description JZ10, P79
 */
public class RectangularCoverage {
    public static void main(String[] args) {

    }
}

class RectangularCoverageSolution {
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }
}
