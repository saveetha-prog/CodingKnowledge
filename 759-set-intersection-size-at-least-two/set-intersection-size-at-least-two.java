import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0]; 
            }
        });
        int ans = 0;
        int p1 = -1; 
        int p2 = -1; 
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start <= p1 && start <= p2) {
                continue;
            } 
            else if (start <= p1) {
                ans++;
                p2 = p1; 
                p1 = end; 
            } 
            else {
                ans += 2;
                p1 = end;
                p2 = end - 1;
            }
        }
        return ans;
    }
}