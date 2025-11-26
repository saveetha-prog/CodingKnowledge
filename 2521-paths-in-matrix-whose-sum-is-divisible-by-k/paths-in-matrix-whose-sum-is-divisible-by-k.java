class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int rem = 0; rem < k; rem++) {
                    if (dp[i][j][rem] == 0) {
                        continue; 
                    }
                    if (i + 1 < m) {
                        int newRem = (rem + grid[i + 1][j]) % k;
                        dp[i + 1][j][newRem] = (dp[i + 1][j][newRem] + dp[i][j][rem]) % MOD;
                    }
                    if (j + 1 < n) {
                        int newRem = (rem + grid[i][j + 1]) % k;
                        dp[i][j + 1][newRem] = (dp[i][j + 1][newRem] + dp[i][j][rem]) % MOD;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}