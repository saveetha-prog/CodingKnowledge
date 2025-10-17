import java.util.HashMap;
import java.util.Map;
class Solution {
    private Map<Long, Integer> memo;
    private int K;
    private String S;
    public int maxPartitionsAfterOperations(String s, int k) {
        this.S = s;
        this.K = k;
        this.memo = new HashMap<>();
        return solve(0, true, 0) + 1;
    }
    private int solve(int index, boolean canChange, int currentMask) {
        if (index == S.length()) {
            return 0;
        }
        long key = ((long) index << 27) | ((canChange ? 1L : 0L) << 26) | currentMask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int maxPartitions = 0;
        char originalChar = S.charAt(index);
        int originalCharBit = 1 << (originalChar - 'a');
        if ((currentMask & originalCharBit) == 0 && countSetBits(currentMask) == K) {
            maxPartitions = Math.max(maxPartitions, 1 + solve(index + 1, canChange, originalCharBit));
        } else {
            maxPartitions = Math.max(maxPartitions, solve(index + 1, canChange, currentMask | originalCharBit));
        }
        if (canChange) {
            for (int i = 0; i < 26; i++) {
                int changedCharBit = 1 << i;
                if ((currentMask & changedCharBit) == 0 && countSetBits(currentMask) == K) {
                    maxPartitions = Math.max(maxPartitions, 1 + solve(index + 1, false, changedCharBit));
                } else {
                    maxPartitions = Math.max(maxPartitions, solve(index + 1, false, currentMask | changedCharBit));
                }
            }
        }
        memo.put(key, maxPartitions);
        return maxPartitions;
    }
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}