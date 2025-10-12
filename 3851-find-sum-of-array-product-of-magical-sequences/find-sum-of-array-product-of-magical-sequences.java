import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][][] mem;
    private int[][] comb; 
    public int magicalSum(int m, int k, int[] nums) {
        mem = new Integer[m + 1][k + 1][nums.length + 1][m + 1]; 
        comb = getComb(m, m); 

        return dp(m, k, 0, 0, nums);
    }
    private int dp(int m, int k, int i, int carry, int[] nums) {
        if (m < 0 || k < 0) return 0; 
        if (i == nums.length) {
            return (m == 0 && Integer.bitCount(carry) == k) ? 1 : 0;
        }
        if (mem[m][k][i][carry] != null) {
            return mem[m][k][i][carry];
        }
        long res = 0;
        for (int count = 0; count <= m; count++) {
            long contribution = (long) comb[m][count] * modPow(nums[i], count) % MOD;
            int newCarry = carry + count;
            res = (res + (long) dp(m - count, k - (newCarry % 2), i + 1, newCarry / 2, nums) * contribution) % MOD;
        }
        return mem[m][k][i][carry] = (int) res;
    }
    private int[][] getComb(int n, int k) {
        int[][] comb = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i && j <= k; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }
        return comb;
    }
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}