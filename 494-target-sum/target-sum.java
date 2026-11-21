class Solution {
    int solve(int[] nums, int target, int i, int sum) {
        if(i == nums.length) return (sum == target) ? 1 : 0;

        int pick = solve(nums, target, i+1, sum + nums[i]);
        int notPick = solve(nums,target, i+1, sum - nums[i]);

        return pick + notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }
}