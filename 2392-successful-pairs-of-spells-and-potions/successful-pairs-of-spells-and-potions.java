import java.util.Arrays;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            long currentSpell = spells[i];
            int low = 0;
            int high = m - 1;
            int firstSuccessfulIndex = m; 
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (currentSpell * potions[mid] >= success) {
                    firstSuccessfulIndex = mid;
                    high = mid - 1; 
                } else {
                    low = mid + 1; 
                }
            }
            result[i] = m - firstSuccessfulIndex;
        }
        return result;
    }
}