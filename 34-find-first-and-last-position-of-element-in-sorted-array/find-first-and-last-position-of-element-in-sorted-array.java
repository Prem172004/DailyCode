class Solution {
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                idx = mid;
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return idx;
    }

    public int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                idx = mid;
                left = mid + 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return idx;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        if(nums.length < 1) return arr;
        arr[0] = lowerBound(nums, target);
        arr[1] = upperBound(nums, target);
        return arr;
    }
}