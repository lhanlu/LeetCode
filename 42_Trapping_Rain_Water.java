/**
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        
        int ans = 0;
        int size = height.length;
        int max = 0;
        int num = 0;
        int[] maxList = new int[size];
        
        for(int k = 0; k < size; k++){
            maxList[k] = height[k];
        }
        
        for(int i = 0; i < size; i++){
            if(height[i] > num){
                max = i;
                num = height[i];
            }
        }
        
        for(int j = 1 ; j <= max; j++){
            if(maxList[j-1] > maxList[j]){
                maxList[j] = maxList[j-1];
            }
        }
        
        for(int l = size-1; l > max+1; l--){
            if(maxList[l] > maxList[l-1]){
                maxList[l-1] = maxList[l];
            }
        }
        
        for(int m = 0; m < size; m++){
            ans += maxList[m] - height[m];
        }
        
        return ans;
    }
}