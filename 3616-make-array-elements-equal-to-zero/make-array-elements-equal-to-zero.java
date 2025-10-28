class Solution {
    public int countValidSelections(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long leftSum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                long rightSum = totalSum - leftSum;
                if (leftSum == rightSum) {
                    ans += 2; 
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    ans += 1; 
                }
            }
            leftSum += nums[i];
        }
        return ans;
    }
}