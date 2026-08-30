class Solution {
    int solve(int[] coins, int sum, int[] dp) {
        if(sum == 0) return 0;

        if(sum < 0) return Integer.MAX_VALUE / 2;

        if(dp[sum] != -1) return dp[sum];

        int min = Integer.MAX_VALUE / 2;

        for(int coin : coins) {
            min = Math.min(min, 1 + solve(coins, sum - coin, dp));
        }
    return dp[sum] = min;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solve(coins, amount,dp);
        if(ans == Integer.MAX_VALUE/2) return -1;
        return ans;
    }
}