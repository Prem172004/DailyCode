class Solution {
    public long countGood(int[] nums, int k) {
        long pairs = 0;
        long result = 0;
        int left = 0;
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++) {
            int num = nums[right];
            int count = map.getOrDefault(num, 0);

            pairs += count;
            map.put(num, count + 1);

            while(pairs >= k) {
                result += (n - right);
                pairs -= (map.get(nums[left]) -1);
                map.put(nums[left],map.get(nums[left]) - 1);
                left++;
            }
        }
        return result;
    }
}