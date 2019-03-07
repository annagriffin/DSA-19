import java.lang.reflect.Array;
import java.util.*;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO

        String endString = "";

        String[] words = s.split(" ");
        HashMap<String, Integer> hash = new HashMap<>();

        for (String w : words) {
            Integer i = hash.get(w);
            if (i == null) {
                i = 1;
            } else {
                i+=1;
            }
            hash.put(w,i);
        }






        HashMap<Integer, ArrayList<String>> hash2 = new HashMap<>();

        for (String st : hash.keySet()) {

            ArrayList<String> strArr = hash2.getOrDefault(hash.get(st),new ArrayList<>());
            strArr.add(st);
            hash2.put(hash.get(st),strArr);

        }

        ArrayList<Integer> nums = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<String>> entry : hash2.entrySet()) {
            nums.add(entry.getKey());
        }

        Collections.sort(nums);



        for (Integer h : nums) {
            ArrayList<String> k = hash2.get(h);
            for (String st : k) {
                System.out.println(st);
                for (int i=0; i<h; i++) {
                    endString += st;
                    endString += " ";
                }
            }
        }



        System.out.print(endString);



        return endString;
    }

}
