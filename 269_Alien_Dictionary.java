/**
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, 
 * where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
 * Example 1: Input: ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:Input:["z","x"]
 * Output: "zx"
 * Example 3: Input:["z","x","z"] 
 * Output: "" 
 * Explanation: The order is invalid, so return "".
 * Note:
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, 
 * then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
class Solution {
    int num = 26;
    public String alienOrder(String[] words) {
        int[] visited = new int[num];
        boolean[][] check = new boolean[num][num];
        StringBuilder sb = new StringBuilder();
        buildGraph(words, visited, check);
        for(int i = 0; i < num; i++){
            if(visited[i] == 0){
                if(!dfs(words, visited, check, sb, i)) return "";
            }
        }

        return sb.reverse().toString();

    }
    private void buildGraph(String[] words, int[] visited, boolean[][] check){
        Arrays.fill(visited, -1);
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                visited[words[i].charAt(j)-'a'] = 0;
            }
            if(i>0){
                String w1 = words[i-1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++){
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2){
                        check[c1-'a'][c2-'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    private boolean dfs(String[] words, int[] visited, boolean[][] check, 
    StringBuilder sb, int i){
        visited[i] = 1;
        for(int j = 0; j < num; j++){
            if(check[i][j]){
                if(visited[j] == 1) return false;
                if(visited[j] == 0){
                    if(!dfs(words, visited, check, sb, j)) return false;
                }
            }
        }
        visited[i] =2;
        sb.append((char)(i+'a'));
        return true;
    }

}