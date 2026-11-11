class Solution {
    void dfs(int[][] Graph, boolean[] vis, int i) {
        vis[i] = true;
        for(int j = 0; j < Graph.length; j++) {
            if(Graph[i][j] == 1 && !vis[j]) {
                dfs(Graph, vis, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
}