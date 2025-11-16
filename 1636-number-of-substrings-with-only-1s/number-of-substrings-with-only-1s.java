class Solution {
    public int numSub(String s) {
        long ans = 0;
        int count = 0; 
        final int MOD = 1_000_000_007; 
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++; 
            } else {
                count = 0; 
            }
            ans = (ans + count) % MOD; 
        }
        return (int) ans;
    }
}