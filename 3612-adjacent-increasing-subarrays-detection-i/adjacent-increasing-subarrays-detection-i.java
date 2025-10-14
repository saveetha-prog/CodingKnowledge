import java.util.List;
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) { 
            return nums.size() >= 2;
        }
        int increasingCount = 1; 
        int prevIncreasingCount = 0; 

        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                increasingCount++;
            } else {
                prevIncreasingCount = increasingCount;
                increasingCount = 1; 
            }
            if (increasingCount / 2 >= k || (prevIncreasingCount >= k && increasingCount >= k)) {
                return true;
            }
        }
        return false;
    }
}
