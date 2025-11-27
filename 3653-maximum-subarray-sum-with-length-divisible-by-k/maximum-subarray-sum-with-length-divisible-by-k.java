import java.util.Arrays;
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long prefix = 0;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        minPrefix[0] = 0; 
        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            int mod = i % k;
        }
        long max_sum = Long.MIN_VALUE;
        long current_prefix_sum = 0;
        long ans_official = Long.MIN_VALUE;
        long prefix_official = 0;
        long[] minPrefix_official = new long[k];
        Arrays.fill(minPrefix_official, Long.MAX_VALUE / 2);
        minPrefix_official[k - 1] = 0; 

        for (int i = 0; i < nums.length; ++i) {
            prefix_official += nums[i];
            int mod_index = i % k;
            ans_official = Math.max(ans_official, prefix_official - minPrefix_official[mod_index]);
            minPrefix_official[mod_index] = Math.min(minPrefix_official[mod_index], prefix_official);
        }
        return ans_official;
    }
}
