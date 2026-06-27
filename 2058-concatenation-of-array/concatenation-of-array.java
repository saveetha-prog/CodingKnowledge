class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] n=new int[nums.length+nums.length];
        for(int i=0;i<nums.length;i++){
            n[i]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            n[nums.length+i]=nums[i];
        }
        return n;
    }
}