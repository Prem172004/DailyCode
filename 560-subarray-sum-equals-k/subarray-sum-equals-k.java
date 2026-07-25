class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix = 0;
        int ans = 0;

        for(int x : nums) {
            prefix += x;
            if(map.containsKey(prefix - k))
                ans += map.get(prefix- k);
            
            map.put(prefix,map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}