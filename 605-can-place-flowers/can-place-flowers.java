class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

                boolean leftEmpty = (i == 0 || nums[i - 1] == 0);
                boolean rightEmpty = (i == nums.length - 1 || nums[i + 1] == 0);

                if (leftEmpty && rightEmpty){
                    nums[i] = 1;                    
                    n -= 1;
                }

                if (n == 0)
                    return true;
            }
        }
        return n <= 0;
    }
}