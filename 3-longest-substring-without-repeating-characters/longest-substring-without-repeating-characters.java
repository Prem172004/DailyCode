class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
            }
            else {
                while(hs.contains(s.charAt(i))) {
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.add(s.charAt(i));
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
    return maxLen;
    }

}