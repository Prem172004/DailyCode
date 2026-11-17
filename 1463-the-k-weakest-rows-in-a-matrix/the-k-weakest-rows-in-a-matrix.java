class Solution {
    int countSoldiers(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );
        for(int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            maxHeap.offer(new int[]{soldiers, i});
            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--) res[i] = maxHeap.poll()[1];
        return res;
    }
}