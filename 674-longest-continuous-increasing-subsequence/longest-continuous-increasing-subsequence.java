class Solution {
    int ans = 1;

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        helper(nums, 1, 1);
        return ans;
    }

    private void helper(int[] nums, int i, int len) {
        if (i == nums.length) {
            ans = Math.max(ans, len);
            return;
        }

        if (nums[i] > nums[i - 1]) {
            helper(nums, i + 1, len + 1);
        } else {
            helper(nums, i + 1, 1);
        }

        ans = Math.max(ans, len);
    }
}
