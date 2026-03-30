import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq1Even = new int[26];
        int[] freq1Odd = new int[26];
        int[] freq2Even = new int[26];
        int[] freq2Odd = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (i % 2 == 0) {
                freq1Even[c1 - 'a']++;
                freq2Even[c2 - 'a']++;
            } else {
                freq1Odd[c1 - 'a']++;
                freq2Odd[c2 - 'a']++;
            }
        }
        boolean evenFrequenciesMatch = Arrays.equals(freq1Even, freq2Even);
        boolean oddFrequenciesMatch = Arrays.equals(freq1Odd, freq2Odd);

        return evenFrequenciesMatch && oddFrequenciesMatch;
    }
}
