class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) q.offer(new int[]{r,c});
            }
        }
        if(q.size() == 0 || q.size() == n*n) return -1;

        int[] dr = {0,0,1,-1}, dc={1,-1,0,0};
        int dist = -1;
        while(!q.isEmpty()) {
            dist++;
            int size = q.size();  
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int d = 0; d < 4; d++) {
                    int nr = cur[0]+dr[d], nc = cur[1]+dc[d];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }    
        }
    return dist;
    }
}