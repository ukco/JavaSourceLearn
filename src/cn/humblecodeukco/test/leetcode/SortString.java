package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/11/25 20:25
 * @Version 1.0
 * @Description 1370. 上升下降字符串
 */
public class SortString {
    /**
     * 桶计数
     * @param s
     * @return
     */
    public String sortString(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (nums[i] > 0) {
                    ret.append((char) (i + 'a'));
                    nums[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (nums[i] > 0) {
                    ret.append((char) (i + 'a'));
                    nums[i]--;
                }
            }
        }
        return ret.toString();
    }
}
