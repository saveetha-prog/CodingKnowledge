class Solution {
    public int minimumOperations(int[] nums) {
        int totalOperations = 0;
        for (int number : nums) {
            int remainder = number % 3;
            if (remainder != 0) {
                totalOperations += Math.min(remainder, 3 - remainder);
            }
        }
        return totalOperations;
    }
}