class Solution {
    boolean backtrack(int i, int[] nums, int k, int val,int curr, boolean[] mark) {
        if(k == 0) return true;
        if(curr == val) {
            return backtrack(0,nums,k-1,val,0,mark);
        }

        for(int j = i; j < nums.length; j++) {
            if(mark[j] || curr + nums[j] > val) {
                continue;
            }
            mark[j] = true;
            if(backtrack(j+1,nums,k,val, curr+nums[j], mark))
                return true;
            mark[j] = false;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total  = 0;
        for(int i : nums) {
            total += i;
        }
        if(total % k != 0) return false;
        Arrays.sort(nums);
        boolean[] marked = new boolean[nums.length];
        return backtrack(0,nums, k, total/k, 0, marked);
    }
}