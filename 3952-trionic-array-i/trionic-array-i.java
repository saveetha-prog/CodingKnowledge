class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        
        if (i == 0) return false;

        int startOfDecreasing = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        
        if (i == startOfDecreasing) return false;

        int startOfSecondIncreasing = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        
        if (i == startOfSecondIncreasing) return false;

        return i == n - 1;
    }
}
