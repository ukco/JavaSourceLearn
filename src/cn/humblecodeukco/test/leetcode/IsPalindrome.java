package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/2 15:27
 * @Version 1.0
 * @Description 9
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindromeSolution isPalindromeSolution = new IsPalindromeSolution();
        System.out.println(isPalindromeSolution.isPalindrome(45454));
    }
}

//class IsPalindromeSolution {
//    public boolean isPalindrome(int x) {
//        if (x < 0 || x > Integer.MAX_VALUE) return false;
//
//        int tmp = x;
//        int y = 0;
//        while (tmp != 0) {
//            y = y * 10 + tmp % 10;
//            tmp /= 10;
//        }
//        return x == y;
//    }
//}

// 方法二
// 时间复杂度：O(logn)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为 O(logn)。
// 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
class IsPalindromeSolution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}