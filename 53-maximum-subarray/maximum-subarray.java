class Solution {
    int cmax(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for(int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for(int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    int solve(int[] nums, int left, int right) {
        //base
        if (left == right)
            return nums[left];
        int mid = left + (right - left) / 2;

        int leftmax = solve(nums, left, mid);
        int rightmax = solve(nums, mid + 1, right);
        int centermax = cmax(nums, left, mid, right);

        return Math.max(leftmax, Math.max(rightmax, centermax));
    }

    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
}