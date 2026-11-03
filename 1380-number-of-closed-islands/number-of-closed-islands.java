class Solution {
    void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0)
            return;
        grid[r][c] = 1;
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && (r == 0 || c == 0 || r == rows - 1 || c == cols - 1))
                    dfs(grid, r, c);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c);
                    count++;
                }
            }

        }
        return count;
    }
}