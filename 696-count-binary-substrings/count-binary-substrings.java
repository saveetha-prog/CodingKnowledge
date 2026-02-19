class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prevEquals = 0; 
        int currEquals = 1; 
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                currEquals++;
            } else {
                ans += Math.min(prevEquals, currEquals);
                prevEquals = currEquals;
                currEquals = 1;
            }
        }
        
        return ans + Math.min(prevEquals, currEquals);
    }
}
