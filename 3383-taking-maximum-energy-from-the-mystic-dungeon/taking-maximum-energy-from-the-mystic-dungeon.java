class Solution {
    public int maximumEnergy(int[] energy, int k) {
                int n = energy.length;
        int[] dp = Arrays.copyOf(energy, n); 
        for (int i = n - 1 - k; i >= 0; i--) {
            dp[i] += dp[i + k];
        }
        int maxEnergy = Integer.MIN_VALUE;
        for (int val : dp) {
            maxEnergy = Math.max(maxEnergy, val);
        }
        return maxEnergy;

    }
}