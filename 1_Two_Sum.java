class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++){
            int num = target - nums[j];
            if(map.containsKey(num) && map.get(num) != j){
                ans[0] = j;
                ans[1] =  map.get(num);
                break;
            }
        }
        return ans;
    }
}