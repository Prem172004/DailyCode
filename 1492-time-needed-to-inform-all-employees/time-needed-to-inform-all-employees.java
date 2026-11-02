class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            if (manager[i] != -1)
                adj.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);

        return dfs(adj, informTime, headID);
    }

    int dfs(Map<Integer, List<Integer>> adj, int[] informTime, int node) {
        int maxTime = 0;
        for (int sub : adj.getOrDefault(node, new ArrayList<>()))
            maxTime = Math.max(maxTime, dfs(adj, informTime, sub));
        return informTime[node] + maxTime;
    }

}