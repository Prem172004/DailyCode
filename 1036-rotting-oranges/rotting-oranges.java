class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[] { r, c });
                if (grid[r][c] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;
        int[] dr = { 0, 0, -1, 1 }, dc = { 1, -1, 0, 0 };
        int min = 0;

        while (!q.isEmpty() && fresh > 0) {
            min++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d], nc = curr[1] + dc[d];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }

        }
        return fresh == 0 ? min : -1;
    }
}