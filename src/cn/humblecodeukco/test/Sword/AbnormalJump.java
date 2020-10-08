package cn.humblecodeukco.test.Sword;

/**
 * @Author lyr
 * @Date 2020/9/26 22:24
 * @Version 1.0
 * @Description JZ9
 */
public class AbnormalJump {
    public static void main(String[] args) {
        AbnormalJumpSolution abnormalJumpSolution = new AbnormalJumpSolution();
        System.out.println(abnormalJumpSolution.JumpFloorII(4));
    }
}

// 方法1
// f(n) = 2^(n-1)
//class AbnormalJumpSolution {
//    public int JumpFloorII(int target) {
//        return (int) Math.pow(2, target - 1);
//    }
//}


// 跳到当前台阶总可能数 = 前面所有台阶可能性 + 1，
// 即f(n) = f(1) + f(2) + ... + f(n-1) + 1，这个1代表直接跳到当前台阶
//class AbnormalJumpSolution {
//    public int JumpFloorII(int target) {
//        int first = 1;
//        int sum = 1;
//        while (target > 1) {
//            sum += first;
//            first = sum;
//            --target;
//        }
//        return sum;
//    }
//}

// f(n) = f(n-1)+f(n-2)+…+f(1)
// f(n-1) = f(n-2)+ f(n-3)…+f(1)
// f(n) = 2*f(n-1)
class AbnormalJumpSolution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}