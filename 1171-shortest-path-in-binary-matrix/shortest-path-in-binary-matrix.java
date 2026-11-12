class Solution {
    int[]dr = {-1,-1,-1,0,0,1,1,1};
    int[]dc = {-1,0,1,-1,1,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        grid[0][0] = 1;
        queue.offer(new int[]{0,0,1});
        while(!queue.isEmpty()) {
            int[] dir = queue.poll();
            if(dir[0] == n-1 && dir[1] == n-1) return dir[2];
            for(int i = 0; i < 8; i++) {
                int nr = dir[0]+dr[i], nc = dir[1]+dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    queue.offer(new int[] {nr,nc,dir[2]+1});
                }
            }
        }
        return -1;
    }
}