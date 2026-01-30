class Solution {
    public boolean isPalindrome(int x) {
        int og=x;
        int res=0;
        while(x>0){
            int rem=x%10;
            x=x/10;
            res=res*10+rem;
        }
        return og==res;
        
    }
}