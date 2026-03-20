import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; ++i) {
            for (int j = 0; j <= n - k; ++j) {
                List<Integer> nums = new ArrayList<>();
                for (int x = i; x < i + k; ++x) {
                    for (int y = j; y < j + k; ++y) {
                        nums.add(grid[x][y]);
                    }
                }
                
                Collections.sort(nums);
                
                int minDiff = Integer.MAX_VALUE;
                for (int t = 1; t < nums.size(); ++t) {
                    if (!nums.get(t).equals(nums.get(t - 1))) {
                        minDiff = Math.min(minDiff, Math.abs(nums.get(t) - nums.get(t - 1)));
                    }
                }
                
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        return ans;
    }
}
