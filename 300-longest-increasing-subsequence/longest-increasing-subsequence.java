class Solution {
    int[][] dp;

    int solve(int[] nums, int idx, int prev) {
        if (idx == nums.length)
            return 0;

        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }

        int taken = 0;
        if (prev == -1 || nums[prev] < nums[idx]) {
            taken = 1 + solve(nums, idx + 1, idx);
        }

        int notTaken = solve(nums, idx + 1, prev);

        return dp[idx][prev + 1] = Math.max(taken, notTaken);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, -1);
    }
}