class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) count++;
            zeros[i] = count;
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int needed = n - 1 - i;
            int k = i;
            while (k < n && zeros[k] < needed) k++;
            if (k == n) return -1;
            
            swaps += (k - i);
            int temp = zeros[k];
            for (int j = k; j > i; j--) zeros[j] = zeros[j - 1];
            zeros[i] = temp;
        }
        return swaps;
    }
}
