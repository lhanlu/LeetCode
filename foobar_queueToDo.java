public class QueueToDo {
 
    
    public static int solution(int start, int length) {
        //Your code goes here.
        int tmp = start;
        int ans = start;
        for(int i = 0; i < length; i++){
            int end = start + length - 1;
            for(int j = start; j <= end - i; j++){
                if(j == tmp) continue;
                ans ^= j;
            }
            start = end + 1;
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        //System.out.println(answer(17, 4));
        System.out.println(solution(17,4));
    }
        
}