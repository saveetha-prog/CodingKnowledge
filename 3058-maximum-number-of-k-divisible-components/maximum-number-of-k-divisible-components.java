class Solution {
    private int ans=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(adj, 0, -1, values, k);
        return ans;
    }
    private long dfs(List<List<Integer>> adj, int u, int parent, int[] values, int k) {
        long currentSubtreeSum = values[u]; 
        for (int v : adj.get(u)) {
            if (v != parent) { 
                currentSubtreeSum += dfs(adj, v, u, values, k);
            }
        }
        if (currentSubtreeSum % k == 0) {
            ans++; 
            return 0; 
        } else {
            return currentSubtreeSum; 
        }
    }
}