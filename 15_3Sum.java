/**
 * Given an array nums of n integers, 
 * are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int l = i+1, r = nums.length-1;
            twoSum(nums, ans, l, r, target);
        }
        return ans;
    }

    private void twoSum(int[] nums, List<List<Integer>> ans, int l, int r, int target){
        while(l < r){
            if(nums[l] + nums[r] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
                while(l<r && nums[r] == nums[r+1]){
                    r--;
                }
            }else if(nums[l] + nums[r] > target){
                r--;
            }else{
                l++;
            }
        }
    }
}