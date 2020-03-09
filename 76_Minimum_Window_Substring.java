/**
 * Given a string S and a string T, find the minimum window
 *  in S which will contain all the characters in T in complexity O(n).
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] ans = new int[2];
        int[] map = new int[256];
        for(char c: tc) map[c]++;
        int l = 0, r = 0, count = tc.length, min = Integer.MAX_VALUE;
        while(r < s.length()){
            char c= sc[r];
            if(map[c] >= 1) count--;
            map[c]--;
            r++;
            while(count == 0){
                if(r-l < min){
                    min = r-l;
                    ans[0] = l;
                    ans[1] = r;
                }
                c = tc[l++];
                if(map[c]++ >= 0) count++;
            }
        }
        return s.substring(ans[0], ans[1]);
    }
  }