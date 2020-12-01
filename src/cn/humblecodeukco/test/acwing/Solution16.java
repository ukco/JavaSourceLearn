package cn.humblecodeukco.test.acwing;

/**
 * @Author lyr
 * @Date 2020/12/1 11:20
 * @Version 1.0
 * @Description 16. 替换空格
 */
public class Solution16 {
    public String replaceSpaces(StringBuffer str) {
        if (str == null) { return null; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') { sb.append("%20"); }
            else { sb.append(str.charAt(i)); }
        }
        return sb.toString();
    }

    public String replaceSpaces2(StringBuffer str) {
        if (str == null) { return null; }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') { str.replace(i, i + 1, "%20"); }
        }
        return str.toString();
    }

    public String replaceSpaces3(StringBuffer str) {
        int a = str.indexOf(" ");
        if (a != -1) { replaceSpaces3(str.replace(a, a + 1, "%20")); }
        return str + "";
    }
}
