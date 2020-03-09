/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, 
 * merge them into [1,6].
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            list.add(intervals[i]);
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                int i1 = a1[0];
                int i2 = a2[0];
                if(i1 < i2) return -1;
                if(i1 > i2) return 1;
                return 0;
            }
        });
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1)[1] >= list.get(i)[1]){
                list.remove(i--);
            }else if(list.get(i-1)[1] >= list.get(i)[0]){
                list.get(i-1)[1] = list.get(i)[1];
                list.remove(i--);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] edited = intervals[i];
            for(int j = 0; j < list.size(); j++){
                int[] origin = list.get(j);
                if(check(origin, edited)){
                    int l = Math.min(origin[0], edited[0]);
                    int r = Math.max(origin[1], edited[1]);
                    edited = new int[]{l1,r};
                    list.remove(j--);
                }
            }
            list.add(edited);
        }

        return list.toArray(new int[list.size()][]);
    }

    private boolean check(int[] origin, int[] edited){
        return (origin[1] >= edited[0] && origin[0] <= edited[1]);
    }
}
