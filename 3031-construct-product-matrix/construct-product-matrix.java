class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] ans = new int[m][n];
        long[] prefixProducts = new long[m * n + 1];
        prefixProducts[0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                prefixProducts[index + 1] = (prefixProducts[index] * grid[i][j]) % MOD;
            }
        }
        
        long suffixProduct = 1;
       
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int index = i * n + j;
                ans[i][j] = (int) ((prefixProducts[index] * suffixProduct) % MOD);
                suffixProduct = (suffixProduct * grid[i][j]) % MOD;
            }
        }
        
        return ans;
    }
}
