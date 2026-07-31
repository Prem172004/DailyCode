class Solution {
    int smallest(int[][] nums, int k) {
        int n = nums.length - 1;
        int count = 0;
        int row = nums.length - 1;
        int col = 0;

        while(row >= 0 && col < nums.length) {
            if(nums[row][col] > k) row -= 1;
            else { 
                count += (row + 1);
                col += 1;
            }
        }
        return count ;
    }

    public int kthSmallest(int[][] matrix, int target) {
        int n = matrix.length;
        int i = matrix[0][0];
        int j = matrix[n -1][n -1];

        while(i <= j) {
            int mid = (i + j) / 2;
            if( target > smallest(matrix, mid)) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }
}