import java.util.*;

class Solution {
    private TreeMap<Integer, Integer> left = new TreeMap<>(); 
    private TreeMap<Integer, Integer> right = new TreeMap<>(); 
    private long currentSum = 0;
    private int leftCount = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int targetCount = k - 1;
        
        
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }
        balance(targetCount);
        
        long minCost = nums[0] + currentSum;
        
        
        for (int i = dist + 2; i < n; i++) {
            remove(nums[i - dist - 1]);
            add(nums[i]);
            balance(targetCount);
            minCost = Math.min(minCost, nums[0] + currentSum);
        }
        
        return minCost;
    }

    private void add(int val) {
        left.put(val, left.getOrDefault(val, 0) + 1);
        currentSum += val;
        leftCount++;
    }

    private void remove(int val) {
        if (left.containsKey(val)) {
            currentSum -= val;
            leftCount--;
            if (left.get(val) == 1) left.remove(val);
            else left.put(val, left.get(val) - 1);
        } else {
            if (right.get(val) == 1) right.remove(val);
            else right.put(val, right.get(val) - 1);
        }
    }

    private void balance(int target) {
        
        while (leftCount > target) {
            int lastKey = left.lastKey();
            removeAndAddToMap(left, right, lastKey);
            currentSum -= lastKey;
            leftCount--;
        }
        
        while (leftCount < target && !right.isEmpty()) {
            int firstKey = right.firstKey();
            removeAndAddToMap(right, left, firstKey);
            currentSum += firstKey;
            leftCount++;
        }
        
        while (!left.isEmpty() && !right.isEmpty() && left.lastKey() > right.firstKey()) {
            int lMax = left.lastKey();
            int rMin = right.firstKey();
            removeAndAddToMap(left, right, lMax);
            removeAndAddToMap(right, left, rMin);
            currentSum = currentSum - lMax + rMin;
        }
    }

    private void removeAndAddToMap(TreeMap<Integer, Integer> from, TreeMap<Integer, Integer> to, int val) {
        if (from.get(val) == 1) from.remove(val);
        else from.put(val, from.get(val) - 1);
        to.put(val, to.getOrDefault(val, 0) + 1);
    }
}
