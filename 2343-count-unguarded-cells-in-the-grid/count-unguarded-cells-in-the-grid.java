class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
                int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { 
                    for (int k = j + 1; k < n; k++) {
                        if (grid[i][k] == 1 || grid[i][k] == 2) { 
                            break;
                        }
                        if (grid[i][k] == 0) { 
                            grid[i][k] = 3;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (grid[i][k] == 1 || grid[i][k] == 2) {
                            break;
                        }
                        if (grid[i][k] == 0) {
                            grid[i][k] = 3;
                        }
                    }
                    for (int k = i + 1; k < m; k++) {
                        if (grid[k][j] == 1 || grid[k][j] == 2) {
                            break;
                        }
                        if (grid[k][j] == 0) {
                            grid[k][j] = 3;
                        }
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (grid[k][j] == 1 || grid[k][j] == 2) {
                            break;
                        }
                        if (grid[k][j] == 0) {
                            grid[k][j] = 3;
                        }
                    }
                }
            }
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { 
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
    }
}