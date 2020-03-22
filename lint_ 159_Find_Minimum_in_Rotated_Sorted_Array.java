/**
 * 159. Find Minimum in Rotated Sorted Array
中文English
Suppose a sorted array in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

Example
Example 1:

Input：[4, 5, 6, 7, 0, 1, 2]
Output：0
Explanation：
The minimum value in an array is 0.
Example 2:

Input：[2,1]
Output：1
Explanation：
The minimum value in an array is 1.
Notice
You can assume no duplicate exists in the array.
 */

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int target = nums[nums.length-1];
        int left = 0, right = nums.length-1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[right]){
                right = mid;
            }else{
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}