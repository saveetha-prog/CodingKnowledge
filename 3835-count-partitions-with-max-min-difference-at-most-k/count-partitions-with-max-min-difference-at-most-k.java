import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefixSum = new long[n + 1]; 
        long MOD = 1_000_000_007;
        dp[0] = 1; 
        prefixSum[0] = 1;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int j = 0; 
        for (int i = 0; i < n; i++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) {
                minDeque.removeLast();
            }
            minDeque.addLast(i);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(i);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (minDeque.peekFirst() == j) {
                    minDeque.removeFirst();
                }
                if (maxDeque.peekFirst() == j) {
                    maxDeque.removeFirst();
                }
                j++;
            }
            dp[i + 1] = (prefixSum[i] - (j > 0 ? prefixSum[j - 1] : 0) + MOD) % MOD;
            prefixSum[i + 1] = (prefixSum[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}