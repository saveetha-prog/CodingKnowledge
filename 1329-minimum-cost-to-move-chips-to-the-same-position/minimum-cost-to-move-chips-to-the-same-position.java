class Solution {
    public int minCostToMoveChips(int[] position) {
        int c1=0;
        int c2=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                c2+=1;
            }if(position[i]%2!=0){
                c1+=1;
            }
        }
        int min=Math.min(c1,c2);
        return min;
    }
}