class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[left] < nums[right])
                return nums[left];
            else {
                if (nums[left] > nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return nums[right];
    }
}