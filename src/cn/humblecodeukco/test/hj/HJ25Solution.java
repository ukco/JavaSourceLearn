package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author lyr
 * @Date 2020/12/2 9:41
 * @Version 1.0
 * @Description HJ25
 */
public class HJ25Solution {
    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String s1 = s.nextLine();
            String s2 = s.nextLine();
            String[] ss1 = s1.split(" ");
            String[] ss2 = s2.split(" ");
            int[] is1 = new int[Integer.parseInt(ss1[0])];
            int[] is3 = new int[Integer.parseInt(ss2[0])];
            Set<Integer> set = new LinkedHashSet<>();

            for (int i = 0; i < is1.length; i++) { is1[i] = Integer.parseInt(ss1[i + 1]); }
            for (int i = 0; i < is3.length; i++) { is3[i] = Integer.parseInt(ss2[i + 1]); }
            for (int i = 0; i < is3.length; i++) { set.add(is3[i]); }

            int[] is2 = new int[set.size()];
            int k = 0;
            for (Integer key: set) {
                is2[k] = key;
                k++;
            }
            Map<Integer, String> map = new LinkedHashMap<>();
            Arrays.sort(is2);
            int num = 0;
            for (int i = 0; i < is2.length; i++) {
                int n = 0;
                map.put(is2[i], "");
                for (int j = 0; j < is1.length; j++) {
                    if (("" + is1[j]).contains("" + is2[i])) {
                        map.put(is2[i], map.get(is2[i]) + " " + j + " " + is1[j]);
                        n++;
                        num += 2;
                    }
                }
                map.put(is2[i], n + map.get(is2[i]));
                if (n != 0) { num += 2; }
            }
            System.out.println(num);
            for (Integer i: map.keySet()) {
                if (map.get(i).length() != 1) {
                    System.out.println(" " + i + " " + map.get(i));
                }
            }
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str = br.readLine())) {
            if ("".equals(str)) { continue; }
            String[] I = str.split(" ");
            String[] temp = br.readLine().split(" ");
            long[] R = new long[Integer.parseInt(temp[0])];
            for (int i = 0; i < R.length; i++) { R[i] = Long.parseLong(temp[i + 1]); }
            Arrays.sort(R);
            StringBuilder res = new StringBuilder();
            int count = 0;
            for (int i = 0; i < R.length; i++) {
                if (i > 0 && R[i] == R[i - 1]) { continue; }
                String pattern = R[i] + "";
                int num = 0;
                StringBuilder index = new StringBuilder();
                for (int j = 1; j < I.length; j++) {
                    if (I[j].contains(pattern)) {
                        num++;
                        index.append(" ").append(j - 1).append(" ").append(I[j]);
                    }
                }
                if (num > 0) {
                    res.append(" ").append(R[i]).append(" ").append(num).append(index);
                    count += num * 2 + 2;
                }
            }
            System.out.println(count + res.toString());
        }
    }
}
