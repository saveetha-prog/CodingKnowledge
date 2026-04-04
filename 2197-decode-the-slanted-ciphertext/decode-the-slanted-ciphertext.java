class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }
        
        int n = encodedText.length();
        int cols = n / rows;
        
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows && (r * cols + (c + r)) < n; r++) {
                result.append(encodedText.charAt(r * cols + (c + r)));
            }
        }
        return result.toString().stripTrailing();
    }
}
