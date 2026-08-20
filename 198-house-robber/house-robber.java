class Solution {
    // int solveRec(int[] nums, int i) {
    //     if (i >= nums.length)
    //         return 0;

    //     int pick = nums[i] + solveRec(nums, i + 2);
    //     int skip = solveRec(nums, i + 1);

    //     return Math.max(pick, skip);
    // }
    // int solveMemo(int[] nums, int i, int[] memo) {
    //     if(i >= nums.length) return 0;

    //     if(memo[i] != -1) return memo[i];

    //     int pick = nums[i] + solveMemo(nums, i+2, memo);
    //     int skip = solveMemo(nums,i+1, memo);

    //     memo[i] = Math.max(pick, skip);
    //     return memo[i];
    // }
    int solveTable(int[] nums) {
        int[] memo = new int[nums.length+2];
        Arrays.fill(memo, -1);
        memo[nums.length] = 0;
        memo[nums.length+1] = 0;

        for(int i = nums.length-1; i >= 0; i--) {
        int pick = nums[i] + memo[i+2];
        int skip = memo[i+1];
        memo[i] = Math.max(pick, skip);
        }
        return memo[0];
    }

    public int rob(int[] nums) {
        //return solveRec(nums, 0);
        //int[] memo = new int[nums.length+1];
       // Arrays.fill(memo, -1);
        //return solveMemo(nums, 0, memo);
        return solveTable(nums);
    }
}