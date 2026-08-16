class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void permute(int[]nums, boolean[] used, List<Integer>path) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            used[i] = true;
            path.add(nums[i]);
            permute(nums, used, path);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        permute(nums, used, path);
        return result;
    }
}