class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int high = arr.length;

        while (lo < high) {
            int mid = lo + (high - lo) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing >= k)
                high = mid;
            else
                lo = mid + 1;
        }

        return lo + k;
    }
}
