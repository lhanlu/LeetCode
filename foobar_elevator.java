/** Inputs: (string list) l = ["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"] 
 * Output: (string list) ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"]
 * Inputs: (string list) l = ["1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"] 
 * Output: (string list) ["0.1", "1.1.1", "1.2", "1.2.1", "1.11", "2", "2.0", "2.0.0"]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Comparator;

public class Solution {
    public static String[] solution(String[] l) {
        // Your code here
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            al.add(l[i]);
        }
        Collections.sort(al, new Comparator<String>(){
            public int compare(String a, String b) 
            {
                String[] l1 = a.split("[.]");
                String[] l2 = b.split("[.]");
                int i = 0;
                int j = 0;
                while(i < l1.length && j < l2.length){
                    if (Integer.parseInt(l1[i]) < Integer.parseInt(l2[j])){
                        return -1;
                    }
                    if (Integer.parseInt(l2[j]) < Integer.parseInt(l1[i])){
                        return 1;
                    }
                    i++;
                    j++;
                }
                return i == l1.length ? -1 : 1;
            }
        });
      for(int i = 0; i < l.length; i++){
        l[i] = al.get(i);
      }
      return l;
    }
  
    public static void main(String[] args){
        String[] s = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
      	solution(s);
      for(String sp : s){
        System.out.println(sp);
    }
    


}
}
