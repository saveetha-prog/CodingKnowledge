class Solution {
    public int hammingDistance(int x, int y) {
        int count=0;
        int c=x^y;
        while(c!=0){
            if((c & 1)==1){
                count++;
            }
            c=c>>1;
        }
        return count;
    }
}