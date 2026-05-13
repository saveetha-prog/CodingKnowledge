class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            delta[Math.min(a, b) + 1]--;
            delta[a + b]--;
            delta[a + b + 1]++;
            delta[Math.max(a, b) + limit + 1]++;
        }
        
        int minMoves = n;
        int currentMoves = n;
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }
        
        return minMoves;
    }
}
