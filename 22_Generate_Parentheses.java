/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"]
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    private void backtrack(List<String> ans, String curr, int left, int right, int n){
        if(curr.length() == n*2){
            ans.add(curr);
            return;
        }
        if(left < n) backtrack(ans, curr+"(", left+1, right, n);
        if(right < left) backtrack(ans, curr+")", left, right+1, n);
    }
}
