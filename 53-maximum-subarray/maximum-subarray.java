class Solution {
    int solve(int[] nums, int currentSum, int maxSum, int i) {
        if (i >= nums.length) return maxSum;

        currentSum = Math.max(currentSum + nums[i], nums[i]);
        maxSum = Math.max(currentSum, maxSum);

        return solve(nums, currentSum, maxSum, i + 1);
    }

    public int maxSubArray(int[] nums) {
        return solve(nums, nums[0], nums[0], 1);
    }
}