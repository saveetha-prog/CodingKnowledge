class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] tempDp = dp.clone();
            for (int sum : tempDp) {
                if (sum == 0 && num % 3 != 0 && dp[num % 3] != 0) {
                }
                int newSum = sum + num;
                int remainder = newSum % 3;
                dp[remainder] = Math.max(dp[remainder], newSum);
            }
        }
        return dp[0];
    }
}