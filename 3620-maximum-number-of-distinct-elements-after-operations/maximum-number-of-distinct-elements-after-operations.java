import java.util.Arrays;
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinctCount = 0;
        long occupied = Long.MIN_VALUE;
        for (int num : nums) {
            long candidate = Math.max(occupied + 1, (long) num - k);
            if (candidate <= (long) num + k) {
                distinctCount++;
                occupied = candidate;
            }
        }
        return distinctCount;
    }
}
