class Solution {
    List<String> ans = new ArrayList<>();
    int N;
    int K;

    public String getHappyString(int n, int k) {
        N = n;
        K = k;
        dfs(new StringBuilder(), ' ');
        if (ans.size() < K) {
            return "";
        }
        
        return ans.get(K - 1);
    }

    private void dfs(StringBuilder currentString, char lastChar) {
        if (ans.size() >= K) {
            return;
        }
        if (currentString.length() == N) {
            ans.add(currentString.toString());
            return;
        }
        for (char nextChar : new char[]{'a', 'b', 'c'}) {
            if (nextChar != lastChar) {
                currentString.append(nextChar);
                dfs(currentString, nextChar);
                currentString.deleteCharAt(currentString.length() - 1);
            }
        }
    }
}
