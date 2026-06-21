class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result=0;
        int full=numBottles;
        while(full>0){
            if(full>=numExchange){
            result+=full-full%numExchange;
            full=(full/numExchange)+(full%numExchange);
        }else{
            result+=full;
            full=0;

        }
        }
        return result;
    }
}