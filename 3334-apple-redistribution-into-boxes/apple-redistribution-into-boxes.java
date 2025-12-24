import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        long totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        Integer[] capacitiesObj = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            capacitiesObj[i] = capacity[i];
        }
        Arrays.sort(capacitiesObj, Collections.reverseOrder());
        long currentCapacitySum = 0;
        int boxesCount = 0;
        for (int cap : capacitiesObj) {
            currentCapacitySum += cap;
            boxesCount++;
            if (currentCapacitySum >= totalApples) {
                return boxesCount;
            }
        }
        return boxesCount; 
    }
}
