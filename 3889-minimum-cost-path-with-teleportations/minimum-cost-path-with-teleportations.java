import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int inf = Integer.MAX_VALUE / 2;
        int[][][] f = new int[k + 1][m][n];
        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(f[t][i], inf);
            }
        }
        f[0][0][0] = 0;
        Map<Integer, List<int[]>> valueToCells = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToCells.computeIfAbsent(grid[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0) f[t][i][j] = Math.min(f[t][i][j], f[t][i - 1][j] + grid[i][j]);
                    if (j > 0) f[t][i][j] = Math.min(f[t][i][j], f[t][i][j - 1] + grid[i][j]);
                }
            }
            if (t < k) {
                int minPrevCost = inf;
                for (Map.Entry<Integer, List<int[]>> entry : valueToCells.entrySet()) {
                    for (int[] pos : entry.getValue()) {
                        minPrevCost = Math.min(minPrevCost, f[t][pos[0]][pos[1]]);
                    }
                    for (int[] pos : entry.getValue()) {
                        f[t + 1][pos[0]][pos[1]] = Math.min(f[t + 1][pos[0]][pos[1]], minPrevCost);
                    }
                }
            }
        }
        int ans = inf;
        for (int t = 0; t <= k; t++) {
            ans = Math.min(ans, f[t][m - 1][n - 1]);
        }
        return ans;
    }
}
