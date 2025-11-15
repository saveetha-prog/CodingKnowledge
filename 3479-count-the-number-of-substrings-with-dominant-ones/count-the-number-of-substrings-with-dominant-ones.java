class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] prefix=new int[n];
        prefix[0]=(s.charAt(0)=='1')?1:0;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(s.charAt(i)=='1'? 1:0);
        }
        int count=0;
        for(int left =0;left<n;left++){
            for(int right=left;right<n;right++){
                int ones=prefix[right]-(left>0?prefix[left-1]:0);
            int zeros=(right-left+1)-ones;
            int sq=zeros*zeros;
            if(sq>ones){
                int need=sq-ones;
                right+=need-1;
            }else if(sq==ones){
                count++;
            }else{
                count++;
                int need=(int)Math.sqrt(ones)-zeros;
                int jump=right+need;
                if(jump>=n){
                    count+=(n-1-right);
                    break;
                }else{
                    count+=need;
                }
                right=jump;
                }
            }
        }
        return count;
    }
}