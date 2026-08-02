class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int high =1_000_000;
        while(lo < high) {
            int mid = lo + (high - lo) / 2;
            if(div(nums, mid) <= threshold) {
                high = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static long div(int[] nums, int val) {
        long total = 0;
        for(int n : nums) {
            total += (long) Math.ceil((double)n / val);
        }
        return total;
    }
}