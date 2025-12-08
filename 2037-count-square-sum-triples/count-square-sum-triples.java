import java.util.HashSet;
import java.util.Set;
class Solution {
    public int countTriples(int n) {
        int ans = 0;
        Set<Integer> squaredValues = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            squaredValues.add(i * i);
        }
        for (int aSquared : squaredValues) {
            for (int bSquared : squaredValues) {
                if (squaredValues.contains(aSquared + bSquared)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}