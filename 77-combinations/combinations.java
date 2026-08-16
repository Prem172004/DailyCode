class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void combine(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            combine(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        combine(n,k,1,path);
        return result;
    }
}