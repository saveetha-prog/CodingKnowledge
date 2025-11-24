class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int currentNum = 0; 
        for (int num : nums) {
            currentNum = (currentNum * 2 + num) % 5;
            result.add(currentNum == 0);
        }
        return result;
    }
}