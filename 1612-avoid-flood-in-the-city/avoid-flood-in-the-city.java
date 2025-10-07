import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lakeToLastRainDay = new HashMap<>();
        TreeSet<Integer> availableDryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int lakeId = rains[i];   
            if (lakeId == 0) {
                availableDryDays.add(i);
                ans[i] = 1; 
            } else {
                ans[i] = -1; 
                if (lakeToLastRainDay.containsKey(lakeId)) {
                    int lastRainDay = lakeToLastRainDay.get(lakeId);
                    Integer dryDay = availableDryDays.ceiling(lastRainDay);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lakeId;
                    availableDryDays.remove(dryDay);
                }
                lakeToLastRainDay.put(lakeId, i);
            }
        }
        for (int dryDay : availableDryDays) {
            ans[dryDay] = 1;
        }
        return ans;
    }
}
