import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCost = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(minCost[i], Long.MAX_VALUE / 2); 
            minCost[i][i] = 0; 
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            minCost[u][v] = Math.min(minCost[u][v], (long) cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] != Long.MAX_VALUE / 2 && minCost[k][j] != Long.MAX_VALUE / 2) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u != v) {
                if (minCost[u][v] == Long.MAX_VALUE / 2) {
                    return -1; 
                }
                totalCost += minCost[u][v];
            }
        }

        return totalCost;
    }
}
