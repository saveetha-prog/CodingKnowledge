class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int battery : batteries) {
            sumPower += battery;
        }
        long left = 0, right = sumPower / n;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRun(n, batteries, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean canRun(int n, int[] batteries, long time) {
        long totalUsablePower = 0;
        for (int battery : batteries) {
            totalUsablePower += Math.min(battery, time);
        }
        return totalUsablePower >= (long) n * time;
    }
}