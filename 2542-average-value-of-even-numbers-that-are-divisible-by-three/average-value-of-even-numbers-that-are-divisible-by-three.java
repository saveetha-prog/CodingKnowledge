class Solution {
    public int averageValue(int[] nums) {
        int sum=0;
        int count=0;
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%3==0){
                if(nums[i]%2==0){
                    sum=sum+nums[i];
                    count+=1;
                    n=sum/count;
                }
            }
           
        }
        return n;
    }
}