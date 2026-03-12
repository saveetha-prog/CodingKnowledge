import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pa] > rank[pb]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 1, right = 200000, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false;
                used++;
            }
        }

        List<int[]> opt = new ArrayList<>();
        for (int[] e : edges) {
            if (e[3] == 0) opt.add(e);
        }

        opt.sort((a, b) -> Integer.compare(b[2], a[2]));

        for (int[] e : opt) {
            int u = e[0], v = e[1], s = e[2];
            int ru = dsu.find(u), rv = dsu.find(v);
            if (ru == rv) continue;

            if (s >= target) {
                dsu.union(u, v);
                used++;
            } else if (s * 2 >= target) {
                upgrades++;
                if (upgrades > k) continue;
                dsu.union(u, v);
                used++;
            }

            if (used == n - 1) return true;
        }

        return used == n - 1 && upgrades <= k;
    }
}