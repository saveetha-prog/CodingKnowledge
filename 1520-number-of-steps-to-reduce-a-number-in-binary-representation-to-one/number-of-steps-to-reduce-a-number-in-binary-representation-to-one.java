class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            int n = sb.length();
            if (sb.charAt(n - 1) == '0') {
                sb.deleteCharAt(n - 1);
                steps++;
            } else {
                int i = n - 1;
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
                steps++;
            }
        }

        return steps;
    }
}
