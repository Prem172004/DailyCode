class Solution {
    public int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) array[i] = nums[i];
            else{
                array[i] = array[i-1]+nums[i];
            }
        }
        return array;
    }
}