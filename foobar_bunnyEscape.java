
public class Solution
{
    
    public static int solution(int[][] map) {
        // Your code here
        int r = map.length;
        int c = map[0].length;
        int[][] deep = new int[r][c];
        int[][] cnt = new int[r][c];
        int[][] cnt2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                    cnt[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                    cnt2[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                    deep[i][j] = -1;
            }
        }
        int layer = 0;
        return Solution.dfs(map, deep,  r-1, c-1, layer, cnt, cnt2, true);
    }
  
    private static int dfs(int[][] map, int[][] deep, int r, int c, int layer, int[][] cnt, int[][] cnt2, boolean breakable) {
        if(r == 0 && c == 0) return 1;
        int min = Integer.MAX_VALUE-1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            r = r + dx[i];
            c = c + dy[i];
            if (r >= 0 && r < map.length && c >= 0 && c < map[0].length && deep[r][c] == -1){
                if (breakable){
                    if(map[r][c] != 1 && cnt[r][c] > ++layer){
                        deep[r][c] = deep[r][c] + 1;
                        cnt[r][c] = layer;
                        int count = dfs(map, deep, r, c, layer, cnt, cnt2, breakable)+1;
                        min = Math.min(count, min);
                        deep[r][c] = deep[r][c] - 1;
                    }
                    if(map[r][c] == 1 && cnt2[r][c] > ++layer){
                        deep[r][c] = deep[r][c] + 1;
                        cnt2[r][c] = layer;
                        int count = dfs(map, deep,  r, c, layer, cnt, cnt2, false)+1;
                        min = Math.min(count, min);
                        deep[r][c] = deep[r][c] - 1;
                    }
                    layer--;
                }else{
                    if(map[r][c] != 1 && cnt2[r][c] > ++layer){
                        deep[r][c] = deep[r][c] + 1;
                        cnt2[r][c] = layer;
                        int count = dfs(map, deep, r, c, layer, cnt, cnt2, breakable)+1;
                        min = Math.min(count, min);
                        deep[r][c] = deep[r][c] - 1;
                    }
                    layer--;
                }
            }
            r = r - dx[i];
            c = c - dy[i];
        }
        return min;
    }
}