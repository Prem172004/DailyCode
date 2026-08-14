class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int lo = 0, high = nums.length - 1;

        while (true) {
            int pivot = partition(nums, lo, high);
            if (pivot == target)
                return nums[pivot];
            else if (pivot < target)
                lo = pivot + 1;
            else
                high = pivot - 1;
        }
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}