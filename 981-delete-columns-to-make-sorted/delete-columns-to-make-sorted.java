class Solution {
    public int minDeletionSize(String[] strs) {
        int deleteCount = 0;
        int rowCount = strs.length;
        int colCount = strs[0].length();
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount - 1; row++) {
                if (strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
}
