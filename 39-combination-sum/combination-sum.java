class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void combine(int[] nums, int remain, int start, List<Integer> path) {
        if (remain < 0)
            return;
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain)
                break;
            path.add(nums[i]);
            combine(nums, remain - nums[i], i, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, 0, path);
        return result;
    }
}