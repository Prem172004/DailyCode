class Solution {
    public int singleNumber(int[] nums) {
        int sol = 0;

        for(int i : nums) {
            sol ^= i;
        }
        return sol;
    }
}