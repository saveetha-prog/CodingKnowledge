import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    public int swimInWater(int[][] grid) {
        final int n = grid.length;
        int minTime = grid[0][0];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentElevation = current[0];
            int row = current[1];
            int col = current[2];
            minTime = Math.max(minTime, currentElevation);
            if (row == n - 1 && col == n - 1) {
                return minTime;
            }
            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    minHeap.add(new int[]{grid[nextRow][nextCol], nextRow, nextCol});
                }
            }
        }
        return minTime; 
    }
}
