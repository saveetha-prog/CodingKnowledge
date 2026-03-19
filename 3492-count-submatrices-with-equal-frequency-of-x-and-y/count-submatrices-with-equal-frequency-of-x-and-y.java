class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] xCount = new int[m + 1][n + 1];
        int[][] yCount = new int[m + 1][n + 1];
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                xCount[i + 1][j + 1] = (grid[i][j] == 'X' ? 1 : 0) + xCount[i][j + 1] + xCount[i + 1][j] - xCount[i][j];
                yCount[i + 1][j + 1] = (grid[i][j] == 'Y' ? 1 : 0) + yCount[i][j + 1] + yCount[i + 1][j] - yCount[i][j];
                if (xCount[i + 1][j + 1] > 0 && xCount[i + 1][j + 1] == yCount[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
