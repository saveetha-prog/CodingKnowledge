import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0;
        }
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);
        int minLength = nums.length;
        int currentPrefixSumModP = 0;
        for (int i = 0; i < nums.length; ++i) {
            currentPrefixSumModP = (currentPrefixSumModP + nums[i]) % p;
            int targetRemainder = (currentPrefixSumModP - remainder + p) % p;
            if (prefixToIndex.containsKey(targetRemainder)) {
                minLength = Math.min(minLength, i - prefixToIndex.get(targetRemainder));
            }
            prefixToIndex.put(currentPrefixSumModP, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}
