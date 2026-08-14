class Solution {
    public void solve(int[][] intervals, int index, List<int[]> result) {
        if(index == intervals.length) return;

        int[] current = intervals[index];
        if(result.isEmpty()) {
            result.add(current);
        } else {
            int[] last = result.get(result.size() - 1);
            if(last[1] >= current[0]) {
                last[1] = Math.max(current[1],last[1]);
            }
            else {
                result.add(current);
            }
        }
        solve(intervals, index+1, result);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        solve(intervals, 0, result);

        return result.toArray(new int[result.size()][]);
    }
}