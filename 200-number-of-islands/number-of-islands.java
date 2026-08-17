class Solution {
    int rows, cols;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') return;

        grid[r][c] = '0';
        for(int[] d : dirs) {
            dfs(grid, r + d[0], c + d[1]);
        }
        
    }
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count+= 1;
                }
            }
        }
        return count;
    }
}