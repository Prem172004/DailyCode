class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Sort by value so we flip most-negative first
        java.util.Arrays.sort(nums);
        
        int i = 0;
        // Flip negative numbers to positive while we can
        while (i < nums.length && k > 0 && nums[i] < 0) {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        
        // If k is still > 0 and odd, flip the smallest element
        if (k % 2 == 1) {
            // Find the smallest element in the now-modified array
            int minIdx = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            nums[minIdx] = -nums[minIdx];
        }
        
        // Sum up
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}