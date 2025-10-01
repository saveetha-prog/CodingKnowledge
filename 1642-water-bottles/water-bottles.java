class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunkBottles = numBottles; 
        int emptyBottles=numBottles;
        while (emptyBottles >= numExchange) {
            int newFullBottles = emptyBottles / numExchange; 
            totalDrunkBottles += newFullBottles; 
            emptyBottles = (emptyBottles % numExchange) + newFullBottles; 
        }
        return totalDrunkBottles;
    }
}