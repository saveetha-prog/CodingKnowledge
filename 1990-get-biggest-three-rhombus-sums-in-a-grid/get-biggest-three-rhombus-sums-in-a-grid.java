import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);

                int maxSize = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));

                for (int k = 1; k <= maxSize; k++) {
                    int sum = 0;

                    int r = i - k, c = j;
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + t][c + t];
                    }
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + k + t][c + k - t];
                    }
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + 2 * k - t][c - t];
                    }
                    for (int t = 0; t < k; t++) {
                        sum += grid[r + k - t][c - k + t];
                    }
                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];
        int idx = 0;

        for (int val : set) {
            if (idx == size) break;
            res[idx++] = val;
        }

        return res;
    }
}