import java.util.Arrays;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                totalSum += cell;
            }
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        long prefixSum = 0;
        for (int i = 0; i < grid.length - 1; i++) { 
            for (int cell : grid[i]) {
                prefixSum += cell;
            }
            if (prefixSum * 2 == totalSum) {
                return true;
            }
        }
        prefixSum = 0;
        for (int j = 0; j < grid[0].length - 1; j++) { 
            for (int i = 0; i < grid.length; i++) {
                prefixSum += grid[i][j];
            }
            if (prefixSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}
