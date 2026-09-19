class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> hmap = new HashMap<>();

        for (char c : p.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        int count = p.length();
        List<Integer> solution = new ArrayList<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (hmap.containsKey(rightChar)) {
                if (hmap.get(rightChar) > 0) {
                    count--;
                }
                hmap.put(rightChar, hmap.get(rightChar) - 1);
            }

            if (right - left + 1 > p.length()) {
                char leftChar = s.charAt(left);
                if (hmap.containsKey(leftChar)) {
                    hmap.put(leftChar, hmap.get(leftChar) + 1);
                    if (hmap.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }

            if (count == 0 ) {
                solution.add(left);
            }
        }
        return solution;
    }
}