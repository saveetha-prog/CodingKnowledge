import java.util.HashMap;
import java.util.Map;
class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> groups = new HashMap<>();
        for (int[] point : points) {
            int y = point[1];
            groups.put(y, groups.getOrDefault(y, 0) + 1);
        }
        Map<Integer, Long> countPairs = new HashMap<>();
        for (int y : groups.keySet()) {
            long n = groups.get(y);
            if (n >= 2) {
                countPairs.put(y, (n * (n - 1) / 2) % MOD);
            }
        }
        long totalTrapezoids = 0;
        long cumulativePairsBelow = 0;
        Integer[] sortedYs = groups.keySet().toArray(new Integer[0]);
        java.util.Arrays.sort(sortedYs);
        long s = 0;
        for (int y : sortedYs) {
            long currentPairs = countPairs.getOrDefault(y, 0L);
            totalTrapezoids = (totalTrapezoids + currentPairs * s) % MOD;
            s = (s + currentPairs) % MOD;
        }
        return (int) totalTrapezoids;
    }
}
