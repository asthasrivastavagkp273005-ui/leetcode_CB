class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        solve(digits, 0, "", ans, map);
        return ans;
    }
    public void solve(String digits, int index, String current,
                      List<String> ans, String[] map) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        int d = digits.charAt(index) - '0';
        String letters = map[d];
        for (int i = 0; i < letters.length(); i++) {
            solve(digits, index + 1,
                  current + letters.charAt(i), ans, map);
        }
    }
}