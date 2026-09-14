class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, memo)) {
                    if (j - i + 1 > maxLen) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int left, int right,
                                  Boolean[][] memo) {

        if (left >= right) {
            return true;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        if (s.charAt(left) != s.charAt(right)) {
            return memo[left][right] = false;
        }

        return memo[left][right] =
                isPalindrome(s, left + 1, right - 1, memo);
    }
}
