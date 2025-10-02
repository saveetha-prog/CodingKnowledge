class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottlesDrunk = 0;
        int emptyBottles = 0;
        while (numBottles > 0) {
            bottlesDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
            while (emptyBottles >= numExchange) {
                emptyBottles -= numExchange;
                numBottles++;
                numExchange++;
            }
        }
        return bottlesDrunk;

    }
}