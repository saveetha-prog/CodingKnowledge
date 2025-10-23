class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int digit1 = Character.getNumericValue(s.charAt(i));
                int digit2 = Character.getNumericValue(s.charAt(i + 1));
                int newDigit = (digit1 + digit2) % 10;
                newS.append(newDigit);
            }
            s = newS.toString(); 
        }
        return s.charAt(0) == s.charAt(1);

    }
}