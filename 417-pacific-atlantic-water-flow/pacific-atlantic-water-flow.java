import java.util.ArrayList;
import java.util.List;
class Solution {
    private int m, n;
    private int[][] heights;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificReachable, heights[0][j]);
            dfs(m - 1, j, atlanticReachable, heights[m - 1][j]);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReachable, heights[i][0]);
            dfs(i, n - 1, atlanticReachable, heights[i][n - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> coords = new ArrayList<>();
                    coords.add(i);
                    coords.add(j);
                    result.add(coords);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable, int prevHeight) {
        if (row < 0 || row >= m || col < 0 || col >= n || reachable[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        reachable[row][col] = true;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(newRow, newCol, reachable, heights[row][col]);
        }
    }
}
