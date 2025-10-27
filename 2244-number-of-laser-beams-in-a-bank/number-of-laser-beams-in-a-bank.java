class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevCount = 0;
        for (String row : bank) {
            int deviceCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') deviceCount++;
            }
            if (deviceCount > 0) {
                totalBeams += prevCount * deviceCount;
                prevCount = deviceCount;
            }
        }
        return totalBeams;
    }
}