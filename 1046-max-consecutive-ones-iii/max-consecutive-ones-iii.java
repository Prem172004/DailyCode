class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                k--;
            if (k < 0) {
                if (nums[j] == 0)
                    k++;
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}