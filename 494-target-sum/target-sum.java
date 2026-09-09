class Solution {
    int solve(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = solve(nums, idx + 1, sum + nums[idx], target);
        int sub = solve(nums, idx + 1, sum - nums[idx], target);

        return add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
}