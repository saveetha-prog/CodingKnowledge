import java.util.*;

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Integer> idMap = new HashMap<>();
        int idCount = 0;
        for (String s : original) if (!idMap.containsKey(s)) idMap.put(s, idCount++);
        for (String s : changed) if (!idMap.containsKey(s)) idMap.put(s, idCount++);
        long[][] dist = new long[idCount][idCount];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int i = 0; i < idCount; i++) dist[i][i] = 0;
        for (int i = 0; i < original.length; i++) {
            int u = idMap.get(original[i]);
            int v = idMap.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k < idCount; k++) {
            for (int i = 0; i < idCount; i++) {
                if (dist[i][k] == Long.MAX_VALUE / 2) continue;
                for (int j = 0; j < idCount; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        Set<Integer> lengths = new HashSet<>();
        for (String s : original) lengths.add(s.length());

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE / 2) continue;
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (int len : lengths) {
                if (i + len <= n) {
                    String sSub = source.substring(i, i + len);
                    String tSub = target.substring(i, i + len);
                    
                    if (idMap.containsKey(sSub) && idMap.containsKey(tSub)) {
                        int u = idMap.get(sSub);
                        int v = idMap.get(tSub);
                        if (dist[u][v] < Long.MAX_VALUE / 2) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                        }
                    }
                }
            }
        }

        return dp[n] >= Long.MAX_VALUE / 2 ? -1 : dp[n];
    }
}
