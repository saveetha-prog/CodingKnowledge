class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return ans;
        String[] keypad = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        fun(digits, "", keypad);
        return ans;
    }
    void fun(String digits, String s, String[] keypad) {
        if (digits.length() == 0) {
            ans.add(s);
            return;
        }
        String key = keypad[digits.charAt(0) - '0'];
        for (int i = 0; i < key.length(); i++) {
            fun(digits.substring(1), s + key.charAt(i), keypad);
        }
    }
}