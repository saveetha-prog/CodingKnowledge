import java.util.*;

class Solution {

    
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
        
       
        public void reset(int i) {
            parent[i] = i;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(n);
        
        uf.union(0, firstPerson);

        Map<Integer, List<int[]>> meetingsByTime = new TreeMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            meetingsByTime.putIfAbsent(time, new ArrayList<>());
            meetingsByTime.get(time).add(meeting);
        }

        for (int time : meetingsByTime.keySet()) {
            List<int[]> currentMeetings = meetingsByTime.get(time);
            for (int[] meeting : currentMeetings) {
                uf.union(meeting[0], meeting[1]);
            }
            for (int[] meeting : currentMeetings) {
                int p1 = meeting[0];
                int p2 = meeting[1];
                if (uf.find(p1) != uf.find(0)) {
                    uf.reset(p1);
                }
                if (uf.find(p2) != uf.find(0)) {
                    uf.reset(p2);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == uf.find(0)) {
                result.add(i);
            }
        }

        return result;
    }
}
