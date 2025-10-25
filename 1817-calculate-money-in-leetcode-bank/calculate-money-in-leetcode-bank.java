class Solution {
    public int totalMoney(int n) {
       int totalMoney = 0;
        int currentWeek = 0;
        for (int day = 0; day < n; day++) {
            if (day % 7 == 0) {
                currentWeek++;
            }
            totalMoney += currentWeek + (day % 7);
        }
        return totalMoney;
 
    }
}