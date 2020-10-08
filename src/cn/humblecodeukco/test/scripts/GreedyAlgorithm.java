package Algorithm;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String,HashSet<String>> broadcasts=new HashMap<String,HashSet<String>> ();
        HashSet<String> hashSet1=new HashSet<String> ();
        hashSet1.add ("北京");
        hashSet1.add ("上海");
        hashSet1.add ("天津");

        HashSet<String> hashSet2=new HashSet<String> ();
        hashSet2.add ("广州");
        hashSet2.add ("北京");
        hashSet2.add ("深圳");
        hashSet2.add ("上海");
        hashSet2.add ("天津");


        HashSet<String> hashSet3=new HashSet<String> ();
        hashSet3.add ("成都");
        hashSet3.add ("上海");
        hashSet3.add ("杭州");


        HashSet<String> hashSet4=new HashSet<String> ();
        hashSet4.add ("上海");
        hashSet4.add ("天津");

        HashSet<String> hashSet5=new HashSet<String> ();
        hashSet5.add ("杭州");
        hashSet5.add ("大连");

        broadcasts.put ("K1",hashSet1);
        broadcasts.put ("K2",hashSet2);
        broadcasts.put ("K3",hashSet3);
        broadcasts.put ("K4",hashSet4);
        broadcasts.put ("K5",hashSet5);

        HashSet<String> allAreas=new HashSet<String> ();
        allAreas.add ("北京");
        allAreas.add ("上海");
        allAreas.add ("天津");
        allAreas.add ("广州");
        allAreas.add ("深圳");
        allAreas.add ("成都");
        allAreas.add ("杭州");
        allAreas.add ("大连");

        ArrayList<String> selects=new ArrayList<String> ();



        String maxKey=null;


        while(allAreas.size ()!=0){
            maxKey=null;

            HashMap<String,HashSet<String>> broadcaststemp=new HashMap<String,HashSet<String>> ();

//            List<HashSet<String>> list = new ArrayList<>();
//            HashSet<String> temp1 = new HashSet<>();
//            HashSet<String> temp2 = new HashSet<>();
//            HashSet<String> temp3 = new HashSet<>();
//            HashSet<String> temp4 = new HashSet<>();
//            HashSet<String> temp5 = new HashSet<>();
//            list.add(temp1);
//            list.add(temp2);
//            list.add(temp3);
//            list.add(temp4);
//            list.add(temp5);
            for(String key: broadcasts.keySet()) {
                HashSet<String> tempSet = new HashSet<> ();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll (areas);
                tempSet.retainAll (allAreas);
                broadcaststemp.put (key,tempSet);
            }

//            if(tempSet.size ()>0 && (maxKey==null || tempSet.size ()>broadcasts.get (maxKey).size ())){
//                maxKey=key;
//            }

            for(String key : broadcaststemp.keySet ()){

                HashSet<String> areastemp = broadcaststemp.get (key);
                if( areastemp.size ()>0 && (maxKey==null || areastemp.size ()>broadcaststemp.get (maxKey).size ())){
                    maxKey=key;
                }
            }


            if(maxKey!=null){
                selects.add (maxKey);
                allAreas.removeAll (broadcaststemp.get (maxKey));
            }

        }

        System.out.println ("得到的选择结果是"+selects);



    }
}
