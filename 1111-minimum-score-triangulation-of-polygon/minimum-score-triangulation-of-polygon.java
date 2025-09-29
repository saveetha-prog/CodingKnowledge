import java.util.Arrays;
class Solution {
    private int[][] dp;
    private int[] values;
    public int minScoreTriangulation(int[] values) {
        this.values = values;
        int n = values.length;
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return util(0, n - 1);
    }
    private int util(int i, int j) {
        if (j - i <= 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minScore = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int currentTriangleScore = values[i] * values[k] * values[j];
            int totalScore = currentTriangleScore + util(i, k) + util(k, j);
            minScore = Math.min(minScore, totalScore);
        }
        dp[i][j] = minScore;
        return minScore;
    }
}