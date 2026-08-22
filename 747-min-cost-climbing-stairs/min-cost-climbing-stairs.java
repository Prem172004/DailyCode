class Solution {
    int solveMemo(int[] cost, int i, int[] dp) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = cost[i] + Math.min(solveMemo(cost, i + 1, dp), solveMemo(cost, i + 2, dp));
        return dp[i];
    }
    // int solve(int[] cost, int i) {
    //     if(i >= cost.length) return 0;

    //     return cost[i] + Math.min(solve(cost, i+1),solve(cost, i + 2));
    // }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(solveMemo(cost, 0, dp), solveMemo(cost, 1, dp));
    }
}