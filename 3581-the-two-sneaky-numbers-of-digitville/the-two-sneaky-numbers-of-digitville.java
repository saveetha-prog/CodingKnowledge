class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        final int MAX_VALUE = 100; 
        int[] count = new int[MAX_VALUE + 1]; 
        int[] ans = new int[2]; 
        int ansIndex = 0; 
        for (int num : nums) {
            count[num]++; 
            if (count[num] == 2) {
                ans[ansIndex++] = num; 
            }
        }
        return ans; 
    }
}