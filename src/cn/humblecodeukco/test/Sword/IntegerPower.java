package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/10/7 11:34
 * @Version 1.0
 * @Description JZ12
 */
public class IntegerPower {
    public static void main(String[] args) {

    }
}

//class IntegerPowerSolution {
//    public double Power(double base, int exponent) {
//        return Math.pow(base, exponent);
//    }
//}

class IntegerPowerSolution {

    boolean g_InvalidInput = false;

    public double Power(double base, int exponent) {
        g_InvalidInput = false;

        if (base == 0.0 && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        long absExponent = (long)exponent;
        if (exponent < 0) absExponent =  (long)(-exponent);

        double result = PowerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

//    private double PowerWithUnsignedExponent(double base, long exponent) {
//        double result = 1.0;
//        for (int i = 1; i <= exponent; ++i) result *= base;
//        return result;
//    }

    private double PowerWithUnsignedExponent(double base, long exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1) result *= base;
        return result;
    }
}