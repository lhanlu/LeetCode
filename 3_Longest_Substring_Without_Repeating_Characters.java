/**
 * Given a string, find the length of the longest 
 * substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, 
 * "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int start = 0, result = 0;
        char[] sa = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            char c = sa[i];
            for(int j = start; j < i; j++){
                if(c == sa[j]){
                    int len = i - start;
                    if(len > result) result = len;
                    start = j+1;
                    break;
                }
            }
        }
        int len = s.length()-start;
        return (len>result)? len: result;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int left = 0, right = 0;
        int ans = 0;
        Set<Character> hs = new HashSet<>();
        while(right < s.length()){
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right++));
                ans = Math.max(ans, hs.size());
            }else{
                hs.remove(s.charAt(left++));
            }
        }
        return ans;
    }
}