class Solution {
    public int minOperations(String s) {
        int cost10 = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' == i % 2) {
                cost10++;
            }
        }
        final int cost01 = n - cost10;
        return Math.min(cost10, cost01);
    }
}
