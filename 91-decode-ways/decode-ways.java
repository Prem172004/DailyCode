class Solution {
    int solve(String s, int i,int[] dp) {
        if(i == s.length()) return 1;

        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int ways = solve(s, i + 1, dp);
        dp[i] = ways;

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));

            if(num >= 10 && num <= 26) {
                ways += solve(s, i+2, dp);
                dp[i] = ways;
            }
        }

        return dp[i];
    }
    public int numDecodings(String s) {
        int memo[] = new int[s.length()+1];
        Arrays.fill(memo, -1);
        return solve(s, 0,memo);
    }
}