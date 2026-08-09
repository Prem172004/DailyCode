class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i : nums) {
            hmap.merge(i, 1, Integer::sum);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(Map.Entry<Integer, Integer> m : hmap.entrySet()) {
            pq.offer(new int[]{m.getKey(),m.getValue()});
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}