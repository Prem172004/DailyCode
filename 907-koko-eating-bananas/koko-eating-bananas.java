class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().orElse(0);
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(mintime(piles, mid) <= h) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    private static long mintime(int[] piles, int val) {
        long total = 0;
        for(int p : piles) {
            total += (p + val - 1) / val;
        }
        return total;
    }
}