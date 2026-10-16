
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            String a = num.substring(0, i);

            if (a.length() > 1 && a.charAt(0) == '0')
                break;

            for (int j = i + 1; j < n; j++) {
                String b = num.substring(i, j);

                if (b.length() > 1 && b.charAt(0) == '0')
                    break;

                if (check(num, j, a, b))
                    return true;
            }
        }

        return false;
    }

    private boolean check(String num, int start,
                          String a, String b) {
        while (start < num.length()) {
            String sum = add(a, b);

            if (!num.startsWith(sum, start))
                return false;

            start += sum.length();
            a = b;
            b = sum;
        }

        return true;
    }

    private String add(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = x + y + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        return ans.reverse().toString();
    }
}
