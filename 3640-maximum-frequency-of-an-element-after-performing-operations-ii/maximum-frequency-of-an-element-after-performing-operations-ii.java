class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums); 
        int n = nums.length;
        int ans = 0;
        TreeSet<Integer>modes=new TreeSet<>();
        Map<Integer,Integer>freq=new HashMap<>();
        int i=0;
        while(i<n){
            int num=nums[i];
            int j=i;
            while(j<n&&nums[j]==num){
                j++;
            }
            int count=j-i;
            freq.put(num,count);
            ans=Math.max(ans,count);
            modes.add(num);
            if(num-k>=nums[0]){
                modes.add(num-k);
            }
            if(num+k<=nums[n-1]){
                modes.add(num+k);
            }
            i=j;
        }
        for(int mode:modes){
            int left=lowerBound(nums,mode-k);
            int right=upperBound(nums,mode+k)-1;
            int countInRange=right-left+1;
            int baseFreq=freq.getOrDefault(mode,0);
            int possible=Math.min(countInRange,baseFreq+numOperations);
            ans=Math.max(ans,possible);
        }
        return ans;
    }
    private int lowerBound(int[] nums,int value){
        int l=0,r=nums.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<value){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    private int upperBound(int[] nums,int value){
        int l=0,r=nums.length;;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<=value){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}