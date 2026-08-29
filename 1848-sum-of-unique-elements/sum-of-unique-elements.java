class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i : nums) {
            hmap.put(i, hmap.getOrDefault(i,0)+1);
        }
        int sum = 0;

        for(Map.Entry<Integer, Integer> map : hmap.entrySet()) {
            if(map.getValue() == 1) {
                sum += map.getKey();
            }
        }
        return sum;
    }
}