
    // void solve(int[][] grid, int m, int n, int sum) {
    //     if(m == grid.length -1 && n == grid[0].length - 1) {
    //         sum += grid[m][n];
    //         minSum = Math.min(sum, minSum);
    //         return;
    //     }
    //     if(m >= grid.length || n >= grid[0].length) return;

    //     sum += grid[m][n];

    //     solve(grid,m+1,n,sum);
    //     solve(grid,m,n+1,sum);

    // }
class Solution {

    int solveMem(int[][] grid, int m, int n, int[][] dp) {

        // Out of bounds
        if (m >= grid.length || n >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        // Destination
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return grid[m][n];
        }

        // Already calculated
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int down = solveMem(grid, m + 1, n, dp);
        int right = solveMem(grid, m, n + 1, dp);

        dp[m][n] = grid[m][n] + Math.min(down, right);

        return dp[m][n];
    }

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solveMem(grid, 0, 0, dp);
    }
}
