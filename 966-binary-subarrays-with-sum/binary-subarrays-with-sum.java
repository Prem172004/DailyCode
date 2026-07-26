class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0;
        int currentSum = 0;

        map.put(0, 1);

        for(int i = 0; i < n; i++) {

            currentSum += nums[i];

            int remaining = currentSum - goal;
            if(map.containsKey(remaining)) {
                result += map.get(remaining);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0)+ 1);
        }
        return result;
    }
}