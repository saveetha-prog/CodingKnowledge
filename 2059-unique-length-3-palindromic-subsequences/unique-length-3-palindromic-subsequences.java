class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, n); 
        int[] lastOccurrence = new int[26];
        Arrays.fill(lastOccurrence, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';
            firstOccurrence[charIndex] = Math.min(firstOccurrence[charIndex], i);
            lastOccurrence[charIndex] = Math.max(lastOccurrence[charIndex], i);
        }
        int uniquePalindromes = 0;
        for (int i = 0; i < 26; i++) {
            int first = firstOccurrence[i];
            int last = lastOccurrence[i];
            if (first < last) {
                Set<Character> middleCharacters = new HashSet<>();
                for (int j = first + 1; j < last; j++) {
                    middleCharacters.add(s.charAt(j));
                }
                uniquePalindromes += middleCharacters.size();
            }
        }
        return uniquePalindromes;
    }
}