class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int lenOfPrev = (int) Math.pow(2, n - 1) - 1;
        int midPos = lenOfPrev + 1;
        if (k == midPos) {
            return '1';
        }
        if (k < midPos) {
            return findKthBit(n - 1, k);
        }
        char originalBit = findKthBit(n - 1, midPos * 2 - k);
        return (originalBit == '0') ? '1' : '0';
    }
}
