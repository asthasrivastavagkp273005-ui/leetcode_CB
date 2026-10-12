
import java.util.*;

class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(0, s);
        return ans;
    }

    void solve(int index, String s) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);

            if (isPalindrome(str)) {
                list.add(str);
                solve(i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
