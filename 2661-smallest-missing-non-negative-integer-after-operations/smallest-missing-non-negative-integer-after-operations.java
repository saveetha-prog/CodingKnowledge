class Solution {
    public int findSmallestInteger(int[] nums, int value) {
         Map<Integer, Integer> remainderCounts = new HashMap<>();
        for (int num : nums) {
            int remainder = (num % value + value) % value;
            remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
        }
        for (int mex = 0; ; mex++) {
            int currentRemainder = mex % value;
            if (!remainderCounts.containsKey(currentRemainder) || remainderCounts.get(currentRemainder) == 0) {
                return mex;
            }
            remainderCounts.put(currentRemainder, remainderCounts.get(currentRemainder) - 1);
        }

    }
}