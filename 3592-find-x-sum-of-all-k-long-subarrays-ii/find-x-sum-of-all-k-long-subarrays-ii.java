import java.util.*;
public class Solution {
    private TreeSet<int[]> l = new TreeSet<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
    private TreeSet<int[]> r = new TreeSet<>(l.comparator());
    private Map<Integer, Integer> cnt = new HashMap<>();
    private long s = 0L;
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            removePair(v);
            cnt.merge(v, 1, Integer::sum);
            addPair(v);
            int j = i - k + 1;
            if (j < 0) continue;
            while (!r.isEmpty() && l.size() < x) {
                int[] p = r.pollLast(); 
                s += 1L * p[0] * p[1];
                l.add(p);
            }
            while (l.size() > x) {
                int[] p = l.pollFirst();
                s -= 1L * p[0] * p[1];
                r.add(p);
            }
            ans[j] = s;
            removePair(nums[j]);
            cnt.merge(nums[j], -1, Integer::sum);
            addPair(nums[j]);
        }
        return ans;
    }
    private void removePair(int v) {
        if (!cnt.containsKey(v)) return;
        int c = cnt.get(v);
        if (c <= 0) return;
        int[] p = new int[]{c, v};
        if (l.contains(p)) {
            l.remove(p);
            s -= 1L * p[0] * p[1];
        } else {
            r.remove(p);
        }
    }
    private void addPair(int v) {
        if (!cnt.containsKey(v)) return;
        int c = cnt.get(v);
        if (c <= 0) return;
        int[] p = new int[]{c, v};
        if (!l.isEmpty() && l.comparator().compare(l.first(), p) < 0) {
            l.add(p);
            s += 1L * p[0] * p[1];
        } else {
            r.add(p);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1,1,2,2,3,4,2,3};
        long[] out1 = sol.findXSum(nums1, 6, 2);
        System.out.println(Arrays.toString(out1));
        sol = new Solution();
        int[] nums2 = {3,8,7,8,7,5};
        long[] out2 = sol.findXSum(nums2, 2, 2);
        System.out.println(Arrays.toString(out2));
    }
}
