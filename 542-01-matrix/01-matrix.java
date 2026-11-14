class Solution {
public int[][] updateMatrix(int[][] mat) {
    int rows = mat.length, cols = mat[0].length;
    int[][] dist = new int[rows][cols];
    boolean[][] visited = new boolean[rows][cols];
    Queue<int[]> q = new LinkedList<>();

    for (int r = 0; r < rows; r++)
        for (int c = 0; c < cols; c++)
            if (mat[r][c] == 0) { q.offer(new int[]{r,c}); visited[r][c]=true; }

    int[] dr = {0,0,1,-1}, dc = {1,-1,0,0};
    while (!q.isEmpty()) {
        int[] cur = q.poll();
        for (int d = 0; d < 4; d++) {
            int nr=cur[0]+dr[d], nc=cur[1]+dc[d];
            if (nr>=0&&nr<rows&&nc>=0&&nc<cols&&!visited[nr][nc]) {
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
    return dist;
}

}