import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(i -> positions[i]));

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : ids) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int top = stack.pop();
                    if (healths[top] > healths[i]) {
                        healths[top]--;
                        healths[i] = 0;
                        stack.push(top);
                    } else if (healths[top] < healths[i]) {
                        healths[i]--;
                        healths[top] = 0;
                    } else {
                        healths[i] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int h : healths) if (h > 0) ans.add(h);
        return ans;
    }
}
