import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String smallestString = s;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String currentString = queue.poll();
            if (currentString.compareTo(smallestString) < 0) {
                smallestString = currentString;
            }
            String addedString = add(currentString, a);
            if (!visited.contains(addedString)) {
                visited.add(addedString);
                queue.offer(addedString);
            }
            String rotatedString = rotate(currentString, b);
            if (!visited.contains(rotatedString)) {
                visited.add(rotatedString);
                queue.offer(rotatedString);
            }
        }
        return smallestString;
    }
    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ('0' + ((chars[i] - '0' + a) % 10));
        }
        return new String(chars);
    }
    private String rotate(String s, int b) {
        int n = s.length();
        b %= n; 
        return s.substring(n - b) + s.substring(0, n - b);
    }
}