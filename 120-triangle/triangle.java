class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];

        return solve(0, 0, triangle, memo);
    }

    private int solve(int row, int col,
                      List<List<Integer>> triangle,
                      Integer[][] memo) {

        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int down = solve(row + 1, col, triangle, memo);

        int diagonal = solve(row + 1, col + 1, triangle, memo);

        memo[row][col] =
            triangle.get(row).get(col) + Math.min(down, diagonal);

        return memo[row][col];
    }
}
