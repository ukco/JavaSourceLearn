package cn.humblecodeukco;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(new Main().Answerofjudge(new int[] {6,6,6,6,5,8}));
    }

    public int Minimumdays (int n, int[] DEF) {
        // write code here
        Arrays.sort(DEF);
        int day = 0;
        for(int i = 0;i<n;i++){
            if(DEF[i]>day){
                day = DEF[i];
            }else {
                day++;
            }
        }
        return day;
    }

    public int Answerofjudge (int[] arr) {
        // write code here
        Arrays.sort(arr);
        double avg = 0;
        for (int i = 0; i < arr.length; i++) { avg = avg + arr[i] * 1.0 / arr.length; }
        double mid;
        if (arr.length % 2 == 0) { mid = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) * 1.0 / 2; }
        else { mid = arr[arr.length / 2]; }
        if (mid == avg) { return 0; }
        else if (mid > avg) { return 1; }
        else { return -1; }
    }


}



