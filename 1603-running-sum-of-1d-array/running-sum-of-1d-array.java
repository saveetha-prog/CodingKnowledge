class Solution {
    public int[] runningSum(int[] nums) {
        int[] n=new int[nums.length];
        for(int i=0;i<nums.length;i++){
                if(i<=0){
                    n[i]=nums[i];
                }else{
                    n[i]=n[i-1]+nums[i];
                }
        }
        return n;
    }
}