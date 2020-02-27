import java.util.Hashtable;

public class Solution {
    public static int solution(int[] x, int[] y) {
        // Your code here
        if(x == null || x.length == 0) return y[0];
        if(y == null || y.length == 0) return x[0];
        
        Hashtable<Integer, Integer> map = new Hashtable<>();
        if(x.length > y.length){
            int[] tmp = x; x = y; y = tmp;
        }
        
        for(int i = 0; i < x.length; i++){
            if(map.contains(x[i])) {map.put(x[i], map.get(x[i])+1);}
            else {map.put(x[i], 1);}
        }
        
        for(int j = 0; j < y.length; j++){
            if(map.contains(y[j])){
                if(map.get(y[j])-1 == 0) {map.remove(y[j]);}
                else{map.put(y[j], map.get(y[j])-1);}
            }else{
                return y[j];
            }
        }
        
        return -100;
    }

    public static void main(String[] args){
        int[] a = {13, 5, 6, 2, 5};
        int[] b = {5,2,13,5};
        System.out.println(solution(a,b));
    }



}