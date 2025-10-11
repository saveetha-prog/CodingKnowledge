class Solution {
    private Long[] memo;
    private int[] uniquePowers;
    private Map<Integer, Integer> count;
    private int n;
    public long maximumTotalDamage(int[] power) {
        count = new HashMap<>();
        for (int p : power) {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }
        uniquePowers = new int[count.size()];
        int i = 0;
        for (int p : count.keySet()) {
            uniquePowers[i++] = p;
        }
        Arrays.sort(uniquePowers);
        n = uniquePowers.length;
        memo = new Long[n];
        return dfs(0);
    }
    private long dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int currentPower = uniquePowers[i];
        long skipDamage = dfs(i + 1);
        int nextIdx = -1;
        int l = i + 1, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (uniquePowers[mid] > currentPower + 2) {
                nextIdx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (nextIdx == -1) {
            nextIdx = n;
        }
        
        long takeDamage = (long) currentPower * count.get(currentPower) + dfs(nextIdx);
        
        return memo[i] = Math.max(skipDamage, takeDamage);
    }
}