class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int processed = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            processed++;
            for(int v : adj.get(u)) {
                if(--indegree[v] == 0) q.offer(v);
            }
        }
        return processed == numCourses;
        }
}