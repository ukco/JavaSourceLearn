package cn.humblecodeukco;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(new Main().Minimumdays(8, new int[] {1,1,1,2,3,5,7,7}));
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
}



