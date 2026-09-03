class Solution {
    public int splitArray(int[] nums, int k) {
        int lo = Arrays.stream(nums).max().orElse(0);
        int high = Arrays.stream(nums).sum();

        while (lo < high) {
            int mid = lo + (high - lo) / 2;

            if (canFit(nums, mid, k)) {
                high = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    boolean canFit(int[] nums, int mid, int k) {
        int count = 1;
        int current = 0;

        for (int b : nums) {
            if (b > mid) {
                return false;
            }

            if (current + b > mid) {
                count++;
                current = b;
            } else {
                current += b;
            }
        }

        return count <= k;
    }
}
