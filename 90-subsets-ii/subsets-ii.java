class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void madarChod(int[] nums, int s, List<Integer> chodu) {
        result.add(new ArrayList<>(chodu));

        for (int i = s; i < nums.length; i++) {
            if (i != s && nums[i] == nums[i - 1])
                continue;
            
            chodu.add(nums[i]);
            madarChod(nums, i + 1, chodu);
            chodu.remove(chodu.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> chodu = new ArrayList<>();
        madarChod(nums, 0, chodu);
        return result;
    }
}