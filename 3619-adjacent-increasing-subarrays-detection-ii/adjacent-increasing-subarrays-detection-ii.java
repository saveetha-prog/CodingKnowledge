import java.util.List;
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int prevIncreasing = 0;
        int curIncreasing = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                curIncreasing++;
            } else {
                ans = Math.max(ans, prevIncreasing / 2);
                ans = Math.max(ans, Math.min(prevIncreasing, curIncreasing));
                prevIncreasing = curIncreasing;
                curIncreasing = 1;
            }
        }
        ans = Math.max(ans, prevIncreasing / 2);
        ans = Math.max(ans, Math.min(prevIncreasing, curIncreasing));
        ans = Math.max(ans, curIncreasing / 2);
        return ans;
    }
}
