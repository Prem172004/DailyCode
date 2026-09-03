class Solution {
    int sol = 0;

    int solve(int m, int n, int i, int j, int[][] dp) {

    if (i == m - 1 && j == n - 1) {
        sol++;
        return 1;
    }

    if (i >= m || j >= n) {
        return 0;
    }

    if(dp[i][j] != -1) return dp[i][j];

    int a = solve(m, n, i + 1, j, dp);
    int b = solve(m, n, i, j + 1, dp);

    return dp[i][j] = a + b;
}


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i : dp) {
            Arrays.fill(i,-1);
        }
        sol = solve(m , n , 0, 0, dp);
        return sol;
    }
}