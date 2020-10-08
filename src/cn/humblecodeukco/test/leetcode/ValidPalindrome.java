package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/9/17 11:08
 * @Version 1.0
 * @Description 125
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindromeSolution validPalindromeSolution = new ValidPalindromeSolution();
        boolean tag = validPalindromeSolution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(tag);
    }
}

// 方法1--正则
//class ValidPalindromeSolution {
//    public boolean isPalindrome(String s) {
//        String sReplace = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        // StringBuffer在处理字符串时，不生成新的对象，在内存上要优于String。
//        // 当遇到插入、删除等字符串操作时可以考虑用StringBuffer
//        // reverse()将一个输入流倒叙输出，方法针对的是io流，不能针对字符串
//        String rev = new StringBuilder(sReplace).reverse().toString();
//        return sReplace.equals(rev);
//    }
//}

// 方法2--筛选+判断
// 1、对字符串s进行一次遍历，并将其中的字母和数字字符进行保留，放在另一个字符串sgood中。
//    这样我们只需要判断sgood是否是一个普通的回文串即可
// 时间复杂度O(|s|)，空间复杂度O(|s|)
//class ValidPalindromeSolution {
//    public boolean isPalindrome(String s) {
//        StringBuffer sgood = new StringBuffer();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                sgood.append(Character.toLowerCase(ch));
//            }
//        }
//        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
//        return sgood.toString().equals(sgood_rev.toString());
//    }
//}

// 方法2--筛选+判断
// 2、使用双指针。初始时，左右指针分别指向sgood的两侧，随后我们不断地将这两个指针相向移动，每次移动
//    一步，并判断这两个指针指向的字符时候相同。当这两个指针相遇时，就说明sgood是回文串。
// 时间复杂度O(|s|)，空间复杂度O(|s|)
//class ValidPalindromeSolution {
//    public boolean isPalindrome(String s) {
//        StringBuffer sgood = new StringBuffer();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if(Character.isLetterOrDigit(ch)) {
//                sgood.append(Character.toLowerCase(ch));
//            }
//        }
//        int left = 0, right = sgood.length()-1;
//        while (left < right) {
//            if (sgood.charAt(left) != sgood.charAt(right)) {
//                return false;
//            }
//            ++left;
//            --right;
//        }
//        return true;
//    }
//}

// 方法3--在原字符串上直接判断
// 直接在原字符串s上使用双指针。在移动任意一个指针时，需要不断地向另一指针的方向移动，直到遇到一个
// 字母或数字字符，或者两指针重合为止。
// 时间复杂度O(|s|)，空间复杂度O(1)
class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}